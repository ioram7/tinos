package rina.ipcservice.impl.test;

import java.util.List;

import rina.cdap.api.CDAPSessionManagerFactory;
import rina.delimiting.api.DelimiterFactory;
import rina.encoding.api.EncoderFactory;
import rina.flowallocator.api.FlowAllocatorInstance;
import rina.flowallocator.api.Flow;
import rina.idd.api.InterDIFDirectoryFactory;
import rina.ipcmanager.api.IPCManager;
import rina.ipcprocess.api.IPCProcess;
import rina.ipcservice.api.APService;

public class MockIPCManager implements IPCManager{

	public void createFlowRequestMessageReceived(Flow arg0,
			FlowAllocatorInstance arg1) {
		// TODO Auto-generated method stub
		
	}

	public void execute(Runnable arg0) {
		// TODO Auto-generated method stub
		
	}

	public APService getAPService() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setInterDIFDirectoryFactory(InterDIFDirectoryFactory arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CDAPSessionManagerFactory getCDAPSessionManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DelimiterFactory getDelimiterFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EncoderFactory getEncoderFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPCProcess getIPCProcessBelongingToDIF(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> listDIFNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IPCProcess> listIPCProcesses() {
		// TODO Auto-generated method stub
		return null;
	}

}
