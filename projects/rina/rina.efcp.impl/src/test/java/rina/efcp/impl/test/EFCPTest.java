package rina.efcp.impl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import rina.efcp.api.DataTransferAE;
import rina.efcp.api.DataTransferConstants;
import rina.efcp.impl.DataTransferAEImpl;
import rina.efcp.impl.DataTransferAEInstanceImpl;
import rina.efcp.impl.PDU;
import rina.flowallocator.api.Connection;
import rina.flowallocator.api.ConnectionId;
import rina.applicationprocess.api.ApplicationProcessNamingInfo;
import rina.utils.types.Unsigned;

public class EFCPTest {
	
	private FakeRMT rmt = null;
	private FakeIPCProcess fakeIPCProcess = null;
	private DataTransferAE dataTransferAE = null;
	private Connection connectionA = null;
	private Connection connectionB = null;
	private DataTransferAEInstanceImpl dataTransferAEInstanceA = null;
	private DataTransferAEInstanceImpl dataTransferAEInstanceB = null;
	private DataTransferConstants dataTransferConstants = new DataTransferConstants();
	
	@Before
	public void setup(){
		rmt = new FakeRMT();
		fakeIPCProcess = new FakeIPCProcess();
		fakeIPCProcess.addIPCProcessComponent(rmt);
		dataTransferAE = new DataTransferAEImpl();
		dataTransferAE.setIPCProcess(fakeIPCProcess);
		fakeIPCProcess.addIPCProcessComponent(dataTransferAE);
		dataTransferAE.setDataTransferConstants(dataTransferConstants);
		initConnectionA();
		initConnectionB();
		dataTransferAEInstanceA = (DataTransferAEInstanceImpl) dataTransferAE.createDataTransferAEInstance(connectionA);
		dataTransferAEInstanceB = (DataTransferAEInstanceImpl) dataTransferAE.createDataTransferAEInstance(connectionB);
		
	}
	
	private void initConnectionA(){
		connectionA = new Connection();
		//QoS id = 0x01, source cep id = 0x01, destination cep id = 0x01
		ConnectionId connectionId = new ConnectionId();
		connectionId.setDestinationCEPId(1);
		connectionId.setSourceCEPId(1);
		connectionId.setQosId(1);
		connectionA.setCurrentConnectionId(connectionId);
		//source address = 0x01, destination address = 0x02
		connectionA.setSourceAddress(1);
		connectionA.setDestinationAddress(2);
		//source application name = "A" destination application name = "B"
		connectionA.setSourceNamingInfo(new ApplicationProcessNamingInfo("A", null));
		connectionA.setDestinationNamingInfo(new ApplicationProcessNamingInfo("B", null));
		connectionA.setMaxGapAllowed(50);
		//source port id = 3, destination port id = 4;
		connectionA.setSourcePortId(3);
		connectionA.setDestinationPortId(4);
	}
	
	private void initConnectionB(){
		connectionB = new Connection();
		//QoS id = 0x01, source cep id = 0x01, destination cep id = 0x01
		ConnectionId connectionId = new ConnectionId();
		connectionId.setDestinationCEPId(1);
		connectionId.setSourceCEPId(1);
		connectionId.setQosId(1);
		connectionB.setCurrentConnectionId(connectionId);
		//source address = 0x02, destination address = 0x01
		connectionB.setSourceAddress(2);
		connectionB.setDestinationAddress(1);
		//source application name = "B" destination application name = "A"
		connectionB.setSourceNamingInfo(new ApplicationProcessNamingInfo("B", null));
		connectionB.setDestinationNamingInfo(new ApplicationProcessNamingInfo("A", null));
		connectionB.setMaxGapAllowed(50);
		//source port id = 4, destination port id = 2;
		connectionB.setSourcePortId(4);
		connectionB.setDestinationPortId(3);
	}
	
	@Test
	public void testBasicEFCPBehaviour(){
		//Produce a single SDU
		List<byte[]> sdus = new ArrayList<byte[]>();
		sdus.add(new String("This is the first message through DTP").getBytes());
		
		//Send the sdu
		dataTransferAEInstanceA.sdusDelivered(sdus);
		
		//Get the SDU from the fake RMT, and check that everything is OK
		PDU pdu = PDU.createPDUFromByteArray(rmt.getPdu(), dataTransferConstants);
		Assert.assertArrayEquals(pdu.getVersion().getBytes(), new byte[]{0x01});
		Assert.assertEquals(pdu.getSourceAddress(), connectionA.getSourceAddress());
		Assert.assertEquals(pdu.getDestinationAddress(), connectionA.getDestinationAddress());
		Assert.assertEquals(pdu.getConnectionId(), connectionA.getCurrentConnectionId());
		Assert.assertArrayEquals(pdu.getFlags().getBytes(), new byte[]{dataTransferConstants.getCompleteFlag()});
		Assert.assertArrayEquals(pdu.getPduType().getBytes(), new byte[]{0x00});
		Assert.assertEquals(pdu.getPduLength(), dataTransferConstants.getPciLength() + 37);
		Assert.assertArrayEquals(pdu.getSequenceNumber().getBytes(), new byte[]{0x00, 0x01});
		Unsigned nextSequenceNumber = pdu.getSequenceNumber().clone();
		nextSequenceNumber.increment();
		Assert.assertEquals(nextSequenceNumber, dataTransferAEInstanceA.getStateVector().getNextSequenceToSend());
		
		dataTransferAEInstanceB.pduDelivered(rmt.getPdu());
		Assert.assertEquals(pdu.getSequenceNumber(), dataTransferAEInstanceB.getStateVector().getLastSequenceDelivered());
	}
}