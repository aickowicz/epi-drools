package com.epiuse.drools.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class DroolsContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		DroolsUtils.init();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
