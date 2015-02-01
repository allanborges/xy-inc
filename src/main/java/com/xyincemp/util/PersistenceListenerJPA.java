package com.xyincemp.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceListenerJPA implements ServletContextListener {

	public PersistenceListenerJPA() {
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		PersistenceManager.getInstance().closeEntityManagerFactory();
	}

}
