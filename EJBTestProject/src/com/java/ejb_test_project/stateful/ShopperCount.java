package com.java.ejb_test_project.stateful;

import javax.ejb.Remote;

@Remote
public interface ShopperCount {
	void incrementShopperCount();
	int getShopperCount();
	void applicationStartup();
	 void applicationShutdown();
}
