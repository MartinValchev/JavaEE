package moduledatabase.services;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import moduledatabase.entities.Customer;

@Stateless
@PersistenceContext(name = "testdatajpa")
public class CustomerServiceImpl implements CustomerService, CustomerServiceLocal {

	@Resource
	SessionContext sessionContext;

	private EntityManager entityManager; 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		entityManager = (EntityManager)sessionContext.lookup("testdatajpa");

		return entityManager.createQuery("SELECT e from Customer e").getResultList();

	}

	@Override
	public void addNewCustomer(Customer customer) {
		if (customer != null) {
			entityManager = (EntityManager)sessionContext.lookup("testdatajpa");
			entityManager.persist(customer);
		}
	}

	@Override
	public Customer getCustomerById(BigDecimal customerId) {
		entityManager = (EntityManager)sessionContext.lookup("testdatajpa");
		return (Customer) entityManager.createQuery("SELECT e from CUSTOMER e where e.id =:customerId")
				.setParameter("customerId", customerId).getSingleResult();
	}

}
