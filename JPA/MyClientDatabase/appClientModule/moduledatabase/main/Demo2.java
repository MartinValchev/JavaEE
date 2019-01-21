package moduledatabase.main;

import javax.naming.Context;

import moduledatabase.entities.Customer;
import moduledatabase.services.CustomerService;

public class Demo2 {

	public static void main(String[] args) {
		try {
			Context context = ClientUtility.getInitialContext();
			
			CustomerService customerService = (CustomerService)context.lookup("moduledatabase.services.CustomerService#moduledatabase.services.CustomerService");
			
		for(Customer customer: customerService.getAllCustomers()) {
			System.out.println("Id: " + customer.getId());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Billing Address: " + customer.getBillingAddress());
			System.out.println("Shipping Address: " + customer.getShippingAddress());
			System.out.println("=================================");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
