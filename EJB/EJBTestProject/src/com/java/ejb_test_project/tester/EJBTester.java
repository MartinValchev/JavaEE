package com.java.ejb_test_project.tester;

import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.java.ejb_test_project.stateful.ShoppingCartBean;

public class EJBTester {
	public static void main(String[] args) {
		try {
			InitialContext  ctx = new InitialContext();
			ShoppingCartBean shoppingCartBean = (ShoppingCartBean)ctx.lookup("ShoppingCartBean");
			shoppingCartBean.addWineItem("Wine_1");
			shoppingCartBean.addWineItem("Wine_2");
			shoppingCartBean.addWineItem("Wine_3");
			shoppingCartBean.addWineItem("Wine_4");
			shoppingCartBean.addWineItem("Wine_5");
			List<String> wineList = shoppingCartBean.getCartItems();
			for (String item: wineList) {
				System.out.println("Item: " + item);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
