package moduledatabase.services;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import moduledatabase.entities.Customer;

	@Local
	public interface CustomerServiceLocal {
		public List<Customer> getAllCustomers();
		public void addNewCustomer(Customer customer);
		public Customer getCustomerById(BigDecimal customerId);
	}

