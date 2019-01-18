package moduledatabase.services;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import moduledatabase.entities.Product;

@Stateless
@PersistenceContext(unitName = "testdatajpa")
public class ProductServiceImpl implements ProductService, ProductServiceLocal, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4132364370329936994L;
	
	@Resource
	private SessionContext context;
	
	private EntityManager  entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		entityManager =  (EntityManager)context.lookup("testdatajpa");
		return entityManager.createQuery("select p from Product p").getResultList();
	}

	@Override
	public void createProduct(Product product) {
		if (product != null) {
			entityManager.persist(product);
		}

	}

}
