package com.java.ejbTest.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import com.java.ejb_test_project.stateful.ShopperCount;
import com.java.ejb_test_project.stateless.SearchFacade;


public class EJBTester {

	public static void main(String[] args) throws NamingException {
		Context  initialContext = ClientUtility.getInitialContext();
		ShopperCount shopperCount = (ShopperCount)initialContext.lookup("com.java.ejb_test_project.stateful.ShopperCount#com.java.ejb_test_project.stateful.ShopperCount");
		SearchFacade searchFacade = (SearchFacade)initialContext.lookup("com.java.ejb_test_project.stateless.SearchFacade#com.java.ejb_test_project.stateless.SearchFacade");
		List<String> winesList = searchFacade.wineSearch("Red");
		 

		System.out.println("<h1>Printing wines list</h1>");
		for (String wine : winesList) {
			System.out.println("Wine: " + wine);
			System.out.println("Printing Shopper Count after incrementing it ...");
			shopperCount.incrementShopperCount();
			System.out.println("<h1>" + shopperCount.getShopperCount() + "</h1>");
		}
		
		shopperCount.incrementShopperCount();
		System.out.println("<h1>" + shopperCount.getShopperCount() + "</h1>");
		

	}

}
