package com.java.ejb_test_project.stateful;

import javax.ejb.Local;

@Local
public interface ShopperCountLocal {
	void incrementShopperCount();
	int getShopperCount();
	void applicationStartup();
	 void applicationShutdown();
}
