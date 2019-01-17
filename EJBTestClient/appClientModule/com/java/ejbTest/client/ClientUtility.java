package com.java.ejbTest.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientUtility {
	public static Context getInitialContext() throws NamingException{
		Properties prop =  new Properties();
		prop.setProperty("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
		prop.setProperty("java.naming.factory.url.pkgs", "com.sun.enterpise.naming");
		prop.setProperty("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
		prop.setProperty("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
		prop.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		return new InitialContext(prop);
	}
}
