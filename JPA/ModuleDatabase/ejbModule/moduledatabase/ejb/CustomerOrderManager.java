package moduledatabase.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import moduledatabase.entities.Address;
import moduledatabase.entities.Customer;
import moduledatabase.entities.CustomerOrder;

@Stateless
public class CustomerOrderManager {
	@PersistenceContext(unitName="testdatajpa")
	private EntityManager entityManager;
	
	public CustomerOrderManager() {}
	
	public <T> T persistsEntity(T entity) {
		entityManager.persist(entity);
		return entity;
	}
	public <T> T mergeEntity(T entity) {
		return entityManager.merge(entity);
	}
	public void removeCustomer(Customer customer) {
		Customer foundCustomer = entityManager.find(Customer.class, customer.getId());
		entityManager.remove(foundCustomer);
	}
	
	public List<Customer> getCustomerFindAll(){
		return entityManager.createNamedQuery("Customer.findAll", Customer.class).getResultList();
	}
	public void removeAddress(Address address) {
		address = entityManager.find(Address.class, address.getId());
		entityManager.remove(address);
	}
	public List<Address> getAddressFindAll(){
		return entityManager.createNamedQuery("Address.findAll", Address.class).getResultList();
	}
	public void removeCustomerOrder(CustomerOrder customerOrder) {
		customerOrder = entityManager.find(CustomerOrder.class, customerOrder.getId()); 
	}
	public List<CustomerOrder> getCustomerOrderFindAll(){
		return entityManager.createNamedQuery("CustomerOrder.findAll", CustomerOrder.class).getResultList();
	}
	public List<CustomerOrder> getCustomerOrderFindByEmail(String email) {
		return entityManager
		.createNamedQuery("CustomerOrder.findByEmail", CustomerOrder.class)
		.setParameter("email", email)
		.getResultList();
		}
}
