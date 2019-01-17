package com.java.ejb_test_project.stateful;

import javax.ejb.Remote;

@Remote
public interface ShoppingCart {
	public String sayHello();
}
