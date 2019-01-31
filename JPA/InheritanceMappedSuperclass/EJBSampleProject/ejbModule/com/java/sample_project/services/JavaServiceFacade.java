package com.java.sample_project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.java.sample_project.entities.Address;
import com.java.sample_project.entities.Employee;
import com.java.sample_project.entities.FullTimeEmployee;
import com.java.sample_project.entities.PartTimeEmployee;
import com.java.sample_project.entities.Person;

@Stateless
public class JavaServiceFacade {
	private final EntityManager entityManager;
	
	public JavaServiceFacade() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("newjpabase");
		entityManager = entityManagerFactory.createEntityManager();
	}
	private void commitTransaction() {
		final EntityTransaction entityTransaction = entityManager.getTransaction();
		if(!entityTransaction.isActive()) {
			entityTransaction.begin();
		}
		entityTransaction.commit();
	}
	  public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
		    Query query = entityManager.createQuery(jpqlStmt);
		    if (firstResult > 0) {
		      query = query.setFirstResult(firstResult);
		    }
		    if (maxResults > 0) {
		      query = query.setMaxResults(maxResults);
		    }
		    return query.getResultList();
		  }
	  public <T> T persistEntity(T entity) {
		  entityManager.persist(entity);
		    commitTransaction();
		    return entity;
		  }

		  public <T> T mergeEntity(T entity) {
		    entity = entityManager.merge(entity);
		    commitTransaction();
		    return entity;
		  }

		  public void removeEmployee(Employee employee) {
		    employee = entityManager.find(Employee.class, employee.getId());
		    entityManager.remove(employee);
		    commitTransaction();
		  }

		  /**
		   * <code>select o from Employee o</code>
		   */
		  public List<Employee> getEmployeeFindAll() {
		    return entityManager.createNamedQuery("Employee.findAll", Employee.class).getResultList();
		  }

		  public void removeFullTimeEmployee(FullTimeEmployee fullTimeEmployee) {
		    fullTimeEmployee = entityManager.find(FullTimeEmployee.class, fullTimeEmployee.getId());
		    entityManager.remove(fullTimeEmployee);
		    commitTransaction();
		  }
		  public void removePartTimeEmployee(PartTimeEmployee partTimeEmployee) {
			    partTimeEmployee = entityManager.find(PartTimeEmployee.class, partTimeEmployee.getId());
			    entityManager.remove(partTimeEmployee);
			    commitTransaction();
			  }

		  /**
		   * <code>select o from PartTimeEmployee o</code>
		   */
		  public List<PartTimeEmployee> getPartTimeEmployeeFindAll() {
		    return entityManager.createNamedQuery("PartTimeEmployee.findAll", PartTimeEmployee.class).getResultList();
		  }
		  /**
		   * <code>select o from FullTimeEmployee o</code>
		   */
		  public List<FullTimeEmployee> getFullTimeEmployeeFindAll() {
		    return entityManager.createNamedQuery("FullTimeEmployee.findAll", FullTimeEmployee.class).getResultList();
		  }
		  public List<Person> getPersonFindAll() {
			    return entityManager.createNamedQuery("Person.findAll", Person.class).getResultList();
			  }
		  /**
		   * <code>select o from Address o</code>
		   */
		  public List<Address> getAddressFindAll() {
		    return entityManager.createNamedQuery("Address.findAll", Address.class).getResultList();
		  }
}
