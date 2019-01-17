package com.java.ejb_test_project.stateful;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful(name="ShoppingCartBean")
public class ShoppingCartBean implements ShoppingCart, ShoppingCartLocal,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3667237120913896125L;

	public ShoppingCartBean() {
	}
	ArrayList<String> cartItems;
	
	@PostConstruct
	public void initialize() {
		cartItems = new ArrayList<>();
	}
	
	public void addWineItem(String wine) {
		cartItems.add(wine);
	}
	
	public void removeWineItem(String wine) {
		cartItems.remove(wine);
	}

	public ArrayList<String> getCartItems() {
		return cartItems;
	}

	public void setCartItems(ArrayList<String> cartItems) {
		this.cartItems = cartItems;
	}
	
	@PreDestroy
	public void exit() {
		System.out.println("Saved items list into database");
	}
	
	@Remove
	public void stopSession() {
		// The method body can be empty.
		System.out.println("From stopSession method with @Remove annotation");
	}

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hellooo Everyone!!!";
	}

}
