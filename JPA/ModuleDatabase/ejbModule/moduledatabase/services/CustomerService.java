package moduledatabase.services;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import moduledatabase.entities.Customer;

@Remote
public interface CustomerService {
	public List<Customer> getAllCustomers();
	public void addNewCustomer(Customer customer);
	public Customer getCustomerById(BigDecimal customerId);
}
