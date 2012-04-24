package rina.utils.apps.connectiongenerator.cliclient;

import rina.applibrary.api.Flow;
import rina.applibrary.api.SDUListener;
import rina.applicationprocess.api.ApplicationProcessNamingInfo;
import rina.ipcservice.api.IPCException;

public class SingleFlowGenerator implements Runnable, SDUListener{
	
	private int duration = 0;
	private String destinationApplication = null;
	private FlowGenerator flowGenerator = null;
	private Flow flow = null;
	
	public SingleFlowGenerator(int duration, String destinationApplication, 
			FlowGenerator flowGenerator){
		this.duration = duration;
		this.destinationApplication = destinationApplication;
		this.flowGenerator = flowGenerator;
	}
	
	public void run() {
		long before = 0;
		
		//Allocate flow
		try{
			before = System.currentTimeMillis();
			flow = new Flow(new ApplicationProcessNamingInfo(Main.SOURCE_APPLICATION, null), 
					new ApplicationProcessNamingInfo(destinationApplication, null), null, this);
			flowGenerator.flowAllocatedSuccessfully(System.currentTimeMillis() - before);
		}catch(IPCException ex){
			flowGenerator.flowWithError();
			return;
		}
		
		//Sleep
		try{
			Thread.sleep(duration);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		//Deallocate flow
		try{
			before = System.currentTimeMillis();
			flow.deallocate();
			flowGenerator.flowCompletedSuccessfully(System.currentTimeMillis() - before);
		}catch(IPCException ex){
			flowGenerator.flowCompletedWithError();
		}
	}

	public void sduDelivered(byte[] sdu) {

	}
}
