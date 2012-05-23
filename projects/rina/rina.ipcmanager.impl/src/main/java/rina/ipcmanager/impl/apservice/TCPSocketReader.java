package rina.ipcmanager.impl.apservice;

import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import rina.cdap.api.CDAPException;
import rina.cdap.api.CDAPSessionManager;
import rina.cdap.api.message.CDAPMessage;
import rina.cdap.api.message.CDAPMessage.Opcode;
import rina.delimiting.api.BaseSocketReader;
import rina.delimiting.api.Delimiter;
import rina.encoding.api.Encoder;
import rina.applicationprocess.api.ApplicationProcessNamingInfo;
import rina.ipcservice.api.ApplicationRegistration;
import rina.ipcservice.api.FlowService;
import rina.ipcservice.api.IPCException;
import rina.ipcservice.api.IPCService;

/**
 * Reads a TCP socket that comes from the "RINA Library" side. 6 CDAP messages can be received:
 * ALLOCATE REQUEST (CDAP M_CREATE) = Start an allocation request.
 * ALLOCATE RESPONSE (CDAP M_CREATE_R) = Submit an allocate response.
 * DEALLOCATE REQUEST (CDAP M_DELETE) = Start a deallocation of a flow.
 * DEALLOCATE RESPONSE (CDAP M_DELETE_R) = Finish the deallocation of a flow.
 * REGISTER APP (CDAP M_START) = Make an application able to accept RINA flows.
 * UNREGISTER APP (CADP M_STOP) = Stop making an application able to accept RINA flows (could be made implicit by just closing the socket, but maybe not a good idea)
 * 
 * Appart from this, if there is a flow established the "RINA library" side will issue delimited PDUs, which are to be sent to
 * the remote endpoint of the flow.
 * @author eduardgrasa
 *
 */
public class TCPSocketReader extends BaseSocketReader{
	
	private static final Log log = LogFactory.getLog(TCPSocketReader.class);
	
	public enum State {NULL, APPLICATION_REGISTRATION, FLOW};

	private CDAPSessionManager cdapSessionManager = null;
	
	private Encoder encoder = null;
	
	private APServiceImpl apService = null;
	
	/**
	 * The state of this socket reader
	 */
	private State state = State.NULL;
	
	/**
	 * The local IPC process the data has to be sent to
	 */
	private IPCService ipcService = null;
	
	/**
	 * The portId associated to the flow established by application process 
	 * that is sending the PDUs to the IPC Manager
	 */
	private int portId = 0;
	
	/**
	 * Controls if this socket will be used for application registration ("server application")
	 * or to establish a data flow ("client application")
	 */
	private ApplicationProcessNamingInfo apNamingInfo = null;

	public TCPSocketReader(Socket socket, Delimiter delimiter, Encoder encoder, CDAPSessionManager cdapSessionManager, APServiceImpl apService){
		super(socket, delimiter);
		this.cdapSessionManager = cdapSessionManager;
		this.apService = apService;
		this.encoder = encoder;
	}
	
	public void setPortId(int portId){
		this.portId = portId;
	}
	
	public void setIPCService(IPCService ipcService){
		this.ipcService = ipcService;
	}
	
	/**
	 * If we are on the connection establishment phase the PDU will be a delimited CDAP message,
	 * if not it will be a delimited sdu that we have to send over the flow
	 * @param pdu
	 */
	public void processPDU(byte[] pdu){
		switch(this.state){
		case NULL:
			try{
				CDAPMessage cdapMessage = null;
				cdapMessage = cdapSessionManager.decodeCDAPMessage(pdu);
				if (cdapMessage.getOpCode() == Opcode.M_CREATE){
					handleMCreateReceived(cdapMessage);
					this.state = State.FLOW;
				}else if (cdapMessage.getOpCode() == Opcode.M_CREATE_R){
					handleMCreateResponseReceived(cdapMessage);
					this.state = State.FLOW;
				}else if (cdapMessage.getOpCode() == Opcode.M_START){
					handleMStartReceived(cdapMessage);
					this.state = State.APPLICATION_REGISTRATION;
				}else{
					log.warn("Received unexpected CDAP message, ignoring it.\n"+cdapMessage.toString());
				}
			}catch(CDAPException ex){
				ex.printStackTrace();
				try{
					CDAPMessage errorMessage = CDAPMessage.getReleaseConnectionResponseMessage(null, 1, "Could not parse CDAP message. " + ex.getMessage() , 1);
					apService.sendErrorMessageAndCloseSocket(errorMessage, getSocket());
				}catch(Exception ex1){
					ex1.printStackTrace();
					try{
						getSocket().close();
					}catch(Exception ex2){
						ex2.printStackTrace();
					}
				}
			}
			break;
		case FLOW:
			handleMWriteReceived(pdu);
		}
	}
	
	/**
	 * Decode the flow service object and call the APService class to initiate the allocation of a new flow
	 * @param cdapMessage
	 */
	private void handleMCreateReceived(CDAPMessage cdapMessage){
		if (apNamingInfo != null){
			//This socket can only be used to modify the application registration information
			//TODO, send error message and close socket?
			return;
		}
		
		try{
			FlowService flowService = (FlowService) encoder.decode(cdapMessage.getObjValue().getByteval(), FlowService.class);
			apService.processAllocateRequest(flowService, cdapMessage, getSocket(), this);
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				CDAPMessage errorMessage = cdapMessage.getReplyMessage();
				errorMessage.setResult(1);
				errorMessage.setResultReason("Could not parse object value. " + ex.getMessage());
				apService.sendErrorMessageAndCloseSocket(errorMessage, getSocket());
			}catch(Exception ex1){
				ex1.printStackTrace();
				try{
					getSocket().close();
				}catch(Exception ex2){
					ex2.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * We have an SDU to deliver. Call the IPC Process and send the data
	 * @param cdapMessage
	 */
	private void handleMWriteReceived(byte[] sdu){
		if (apNamingInfo != null){
			//This socket can only be used to modify the application registration information
			//TODO, send error message and close socket?
			return;
		}
		
		if (ipcService == null){
			log.error("Received a request to transfer data on portId "+portId+", but there is no flow allocated yet");
			//There is no flow allocated yet, what to do?
			//TODO a) ignore, b) send an error message c) send and error message and close the flow?
			return;
		}
		
		try {
			ipcService.submitTransfer(portId, sdu);
		} catch (IPCException ex) {
			ex.printStackTrace();
			//TODO, what else to do?
		}
	}
	
	/**
	 * Decode the application registration object and call the APService class to initiate the allocation of a new flow
	 * @param cdapMessage
	 */
	private void handleMStartReceived(CDAPMessage cdapMessage){
		if (ipcService != null){
			//This socket can only be used for data transfer
			//TODO send error message and close socket?
			return;
		}
		
		try{
			ApplicationRegistration applicationRegistration = (ApplicationRegistration) encoder.decode(cdapMessage.getObjValue().getByteval(), ApplicationRegistration.class);
			apService.processApplicationRegistrationRequest(applicationRegistration, cdapMessage, getSocket(), this);
			apNamingInfo = applicationRegistration.getApNamingInfo();
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				CDAPMessage errorMessage = cdapMessage.getReplyMessage();
				errorMessage.setResult(1);
				errorMessage.setResultReason("Could not parse object value. " + ex.getMessage());
				apService.sendErrorMessageAndCloseSocket(errorMessage, getSocket());
			}catch(Exception ex1){
				ex1.printStackTrace();
				try{
					getSocket().close();
				}catch(Exception ex2){
					ex2.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Decode the flow service object and call the APService class to confirm the allocation of a new flow
	 * @param cdapMessage
	 */
	private void handleMCreateResponseReceived(CDAPMessage cdapMessage){
		if (apNamingInfo != null){
			//This socket can only be used to modify the application registration information
			//TODO, send error message and close socket?
			return;
		}
		
		apService.processAllocateResponse(cdapMessage, portId, this);
	}
	
	/**
	 * Invoked when the socket is disconnected
	 */
	public void socketDisconnected(){
		apService.processSocketClosed(portId, apNamingInfo);
	}
}
