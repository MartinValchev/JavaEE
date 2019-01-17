package com.java.ejb_test_project.stateful;

import javax.ejb.Local;

@Local
public interface ShoppingCartLocal {
	public String sayHello();
}

