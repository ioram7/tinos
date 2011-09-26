package rina.rmt.impl.tcp;

import java.util.HashMap;
import java.util.Map;

import rina.ipcservice.api.ApplicationProcessNamingInfo;
import rina.rmt.api.RMT;
import rina.rmt.api.RMTFactory;

public class TCPRMTFactoryImpl implements RMTFactory{

	private Map<ApplicationProcessNamingInfo, RMT> rmtRespository = null;
	
	public TCPRMTFactoryImpl(){
		rmtRespository = new HashMap<ApplicationProcessNamingInfo, RMT>();
	}
	
	public RMT createRMT(ApplicationProcessNamingInfo ipcProcessNamingInfo) {
		RMT rmt = null;
		try {
			rmt = new TCPRMTImpl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rmtRespository.put(ipcProcessNamingInfo, rmt);
		return rmt;
	}

	public void destroyRMT(ApplicationProcessNamingInfo ipcProcessNamingInfo) {
		rmtRespository.remove(ipcProcessNamingInfo);
	}

	public RMT getRMT(ApplicationProcessNamingInfo ipcProcessNamingInfo) {
		return rmtRespository.get(ipcProcessNamingInfo);
	}

}