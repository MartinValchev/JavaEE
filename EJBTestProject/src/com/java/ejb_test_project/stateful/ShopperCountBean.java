package com.java.ejb_test_project.stateful;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ShopperCountBean implements ShopperCount,ShopperCountLocal,Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6229295412794608754L;
	private int shopperCounter;
	
	@Lock(LockType.WRITE)
	public void incrementShopperCount() {
		shopperCounter++;
		}
		// Return number of shoppers
		@Lock(LockType.READ)
		public int getShopperCount() {
		return shopperCounter;
		}
	public void resetCounter() {
		shopperCounter =0;
	}
	
	@PostConstruct
	public void applicationStartup() {
		System.out.println("From applicationStartup method.");
		resetCounter();
	}
	
	public String sayHello() {
		return "Hellooo!!!";
	}
	@PreDestroy
	public void applicationShutdown() {
		System.out.println("From application shutdown method");
	}
	
}
