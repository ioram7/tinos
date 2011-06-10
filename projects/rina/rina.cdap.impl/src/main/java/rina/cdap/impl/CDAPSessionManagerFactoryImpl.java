package rina.cdap.impl;

import rina.cdap.api.CDAPSessionManager;
import rina.cdap.api.CDAPSessionManagerFactory;

public class CDAPSessionManagerFactoryImpl implements CDAPSessionManagerFactory{

	/**
	 * Injected by Spring
	 */
	private WireMessageProviderFactory wireMessageProviderFactory = null;
	
	public CDAPSessionManager createCDAPSessionManager() {
		CDAPSessionManagerImpl cdapSessionManager = new CDAPSessionManagerImpl();
		cdapSessionManager.setWireMessageProviderFactory(wireMessageProviderFactory);
		return new CDAPSessionManagerImpl();
	}
	
	public void setWireMessageProviderFactory(WireMessageProviderFactory wireMessageProviderFactory){
		this.wireMessageProviderFactory = wireMessageProviderFactory;
	}

}
