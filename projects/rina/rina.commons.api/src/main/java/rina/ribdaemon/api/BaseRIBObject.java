package rina.ribdaemon.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import rina.cdap.api.CDAPException;
import rina.cdap.api.CDAPSessionDescriptor;
import rina.cdap.api.message.CDAPMessage;
import rina.cdap.api.message.ObjectValue;
import rina.encoding.api.BaseEncoder;
import rina.encoding.api.Encoder;
import rina.ipcprocess.api.IPCProcess;

/**
 * The base RIB Handler that provides a default behaviour for the RIB Handlers. 
 * The default behaviour consists in throwing exceptions because the operation 
 * is not supported and returning CDAP Error messages for the same reason. The 
 * error code for the operation not supported is "1".
 * Subclasses just need to overwrite the methods that are allowed in a certain RIB 
 * object.
 * It also provides some basic machinery that will be required to encode/decode 
 * the CDAP message contents and a pointer to the RIB Daemon.
 * @author eduardgrasa
 *
 */
public class BaseRIBObject implements RIBObject{
	
	private static final Log log = LogFactory.getLog(BaseRIBObject.class);
	private IPCProcess ipcProcess = null;
	private Encoder encoder = null;
	private RIBDaemon ribDaemon = null;
	
	/**
	 * The attributes of this object: objectName, objectClass, objectInstance
	 */
	private String objectName = null;
	private String objectClass = null;
	private long objectInstance = 0;
	
	/**
     * The list of children of this object in the RIB
     */
    private List<RIBObject> children = null;
    
    /**
     * The parent object of this object in the RIB
     */
    private RIBObject parent = null;
	
	public BaseRIBObject(IPCProcess ipcProcess, String objectName, String objectClass, long objectInstance){
		children = new ArrayList<RIBObject>();
		this.ipcProcess = ipcProcess;
		this.objectName = objectName;
		this.objectClass = objectClass;
		this.objectInstance = objectInstance;
	}
	
	public String getObjectName(){
		return this.objectName;
	}
	
	public String getObjectClass(){
		return this.objectClass;
	}
	
	public long getObjectInstance(){
		return this.objectInstance;
	}
	
	public IPCProcess getIPCProcess(){
		return this.ipcProcess;
	}
	
	public RIBObject getParent(){
		return this.parent;
	}
	
	public void setParent(RIBObject parent){
		this.parent = parent;
	}
	
	/**
    * Return the children of RIBObject. The RIB is represented by a single
    * root RIBObject whose children are represented by a List<RIBObject>. Each of
    * these RIBObject elements in the List can have children. The getChildren()
    * method will return the children of a RIBObject.
    * @return the children of RIBObject
    */
   public List<RIBObject> getChildren() {
       return this.children;
   }

   /**
    * Sets the children of a RIBObject object. See docs for getChildren() for
    * more information.
    * @param children the List<RIBObject> to set.
    */
   public void setChildren(List<RIBObject> children) {
       this.children = children;
   }

   /**
    * Returns the number of immediate children of this RIBNode.
    * @return the number of immediate children.
    */
   public int getNumberOfChildren() {
       return children.size();
   }
    
   /**
    * Adds a child to the list of children for this RIBObject. The addition of
    * the first child will create a new List<RIBObject>.
    * @param child a RIB object to set.
    */
   public void addChild(RIBObject child) throws RIBDaemonException{
	   for(int i=0; i<children.size(); i++){
		if (children.get(i).getObjectName().equals(child.getObjectName())){
			throw new RIBDaemonException(RIBDaemonException.OBJECT_ALREADY_HAS_THIS_CHILD);
		}
	   }
	   
       children.add(child);
       child.setParent(this);
   }
   
   public void removeChild(String objectName) throws RIBDaemonException{
	   RIBObject child = null;
	   
	   for(int i= 0; i<children.size(); i++){
		   child = children.get(i);
		   if (child.getObjectName().equals(objectName)){
			   children.remove(child);
			   child.setParent(null);
			   return;
		   }
	   }
	   
	   throw new RIBDaemonException(RIBDaemonException.CHILD_NOT_FOUND);
   }
	
	public Encoder getEncoder(){
		if (this.encoder == null){
			this.encoder = (Encoder) ipcProcess.getIPCProcessComponent(BaseEncoder.getComponentName());
		}
		
		return this.encoder;
	}
	
	public RIBDaemon getRIBDaemon(){
		if (this.ribDaemon == null){
			this.ribDaemon = (RIBDaemon) ipcProcess.getIPCProcessComponent(BaseRIBDaemon.getComponentName());
		}
		
		return this.ribDaemon;
	}

	public void create(String objectClass, String objectName, long objectInstance, Object object) throws RIBDaemonException {
		throw new RIBDaemonException(RIBDaemonException.OPERATION_NOT_ALLOWED_AT_THIS_OBJECT, 
				"Operation CREATE not allowed for objectName "+objectName);
	}

	public void delete(String objectClass, String objectName, long objectInstance, Object object) throws RIBDaemonException {
		throw new RIBDaemonException(RIBDaemonException.OPERATION_NOT_ALLOWED_AT_THIS_OBJECT, 
				"Operation DELETE not allowed for objectName "+objectName);
	}

	public Object read(String objectClass, String objectName, long objectInstance) throws RIBDaemonException {
		throw new RIBDaemonException(RIBDaemonException.OPERATION_NOT_ALLOWED_AT_THIS_OBJECT, 
				"Operation READ not allowed for objectName "+objectName);
	}

	public void write(String objectClass, String objectName, long objectInstance, Object object) throws RIBDaemonException {
		throw new RIBDaemonException(RIBDaemonException.OPERATION_NOT_ALLOWED_AT_THIS_OBJECT, 
				"Operation WRITE not allowed for objectName "+objectName);
	}

	public void start(String objectClass, String objectName, long objectInstance, Object object) throws RIBDaemonException {
		throw new RIBDaemonException(RIBDaemonException.OPERATION_NOT_ALLOWED_AT_THIS_OBJECT, 
				"Operation START not allowed for objectName "+objectName);
	}

	public void stop(String objectClass, String objectName, long objectInstance, Object object) throws RIBDaemonException {
		throw new RIBDaemonException(RIBDaemonException.OPERATION_NOT_ALLOWED_AT_THIS_OBJECT, 
				"Operation STOP not allowed for objectName "+objectName);
	}

	public void read(CDAPMessage cdapMessage, CDAPSessionDescriptor cdapSessionDescriptor) throws RIBDaemonException {
		CDAPMessage responseMessage = null;
		
		try{
			Object object = this.read(cdapMessage.getObjClass(), cdapMessage.getObjName(), cdapMessage.getObjInst());
			ObjectValue objectValue = null;
			if (object != null){
				objectValue = new ObjectValue();
				objectValue.setByteval(getEncoder().encode(object));
			}
			responseMessage = CDAPMessage.getReadObjectResponseMessage(null, cdapMessage.getInvokeID(), cdapMessage.getObjClass(), 
					cdapMessage.getObjInst(), cdapMessage.getObjName(), objectValue, 0, null);
			getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
		}catch(RIBDaemonException ex){
			try{
				responseMessage = CDAPMessage.getReadObjectResponseMessage(null, cdapMessage.getInvokeID(), cdapMessage.getObjClass(), 
						cdapMessage.getObjInst(), cdapMessage.getObjName(), null, 1, ex.getMessage());
				getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
			}catch(CDAPException cdapEx){
				log.error(cdapEx);
			}
		}catch(Exception ex){
			log.error(ex);
		}
	}

	public void write(CDAPMessage cdapMessage, CDAPSessionDescriptor cdapSessionDescriptor) throws RIBDaemonException {
		CDAPMessage responseMessage = null;
		
		try{
			Object object = getEncoder().decode(cdapMessage.getObjValue().getByteval(), ObjectNametoClassMapper.getObjectClass(cdapMessage.getObjName()));
			this.write(cdapMessage.getObjClass(), cdapMessage.getObjName(), cdapMessage.getObjInst(), object);
			if (cdapMessage.getInvokeID() != 0){
				responseMessage = CDAPMessage.getWriteObjectResponseMessage(null, cdapMessage.getInvokeID(), 0, null);
				getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
			}
		}catch(Exception ex){
			try{
				responseMessage = CDAPMessage.getWriteObjectResponseMessage(null, cdapMessage.getInvokeID(), 1, ex.getMessage());
				getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
			}catch(CDAPException cdapEx){
				log.error(ex);
			}
		}
	}
	
	public void create(CDAPMessage cdapMessage, CDAPSessionDescriptor cdapSessionDescriptor) throws RIBDaemonException {
		CDAPMessage responseMessage = null;
		
		try{
			Object object = getEncoder().decode(cdapMessage.getObjValue().getByteval(), ObjectNametoClassMapper.getObjectClass(cdapMessage.getObjName()));
			this.create(cdapMessage.getObjClass(), cdapMessage.getObjName(), cdapMessage.getObjInst(), object);
			if (cdapMessage.getInvokeID() != 0){
				responseMessage = CDAPMessage.getCreateObjectResponseMessage(null, cdapMessage.getInvokeID(), 
						cdapMessage.getObjClass(), 0, cdapMessage.getObjName(), cdapMessage.getObjValue(), 0, null);
				getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
			}
		}catch(Exception ex){
			try{
				responseMessage = CDAPMessage.getCreateObjectResponseMessage(null, cdapMessage.getInvokeID(), 
						cdapMessage.getObjClass(), 0, cdapMessage.getObjName(), cdapMessage.getObjValue(), 1, ex.getMessage());
				getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
			}catch(CDAPException cdapEx){
				log.error(ex);
			}
		}
	}

	public void delete(CDAPMessage cdapMessage, CDAPSessionDescriptor cdapSessionDescriptor) throws RIBDaemonException {
		CDAPMessage responseMessage = null;

		try{
			this.delete(cdapMessage.getObjClass(), cdapMessage.getObjName(), cdapMessage.getObjInst(), null);
			if (cdapMessage.getInvokeID() != 0){
				responseMessage = CDAPMessage.getDeleteObjectResponseMessage(null, cdapMessage.getInvokeID(), 
						cdapMessage.getObjClass(), 0, cdapMessage.getObjName(), 0, null);
				getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
			}
		}catch(Exception ex){
			try{
				responseMessage = CDAPMessage.getDeleteObjectResponseMessage(null, cdapMessage.getInvokeID(), 
						cdapMessage.getObjClass(), 0, cdapMessage.getObjName(), 1, ex.getMessage());
				getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
			}catch(CDAPException cdapEx){
				log.error(ex);
			}
		}
	}

	public void cancelRead(CDAPMessage cdapMessage, CDAPSessionDescriptor cdapSessionDescriptor) throws RIBDaemonException {
		try{
			CDAPMessage responseMessage = CDAPMessage.getCancelReadResponseMessage(null, 
					cdapMessage.getInvokeID(), 1, "Operation CANCELREAD not allowed for objectName "+cdapMessage.getObjName());
			getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
		}catch(CDAPException ex){
			log.error("Error generating CANCELREAD response message. Details:");
			log.error(ex);
		}
	}

	public void start(CDAPMessage cdapMessage, CDAPSessionDescriptor cdapSessionDescriptor) throws RIBDaemonException {
		try{
			CDAPMessage responseMessage = CDAPMessage.getStartObjectResponseMessage(null, 
					cdapMessage.getInvokeID(), 1, "Operation START not allowed for objectName "+cdapMessage.getObjName());
			getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
		}catch(CDAPException ex){
			log.error("Error generating START response message. Details:");
			log.error(ex);
		}
	}

	public void stop(CDAPMessage cdapMessage, CDAPSessionDescriptor cdapSessionDescriptor) throws RIBDaemonException {
		try{
			CDAPMessage responseMessage = CDAPMessage.getStopObjectResponseMessage(null, 
					cdapMessage.getInvokeID(), 1, "Operation STOP not allowed for objectName "+cdapMessage.getObjName());
			getRIBDaemon().sendMessage(responseMessage, cdapSessionDescriptor.getPortId(), null);
		}catch(CDAPException ex){
			log.error("Error generating STOP response message. Details:");
			log.error(ex);
		}
	}
}
