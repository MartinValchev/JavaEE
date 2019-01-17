package moduledatabase.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import moduledatabase.entities.Product;

@Stateless
public class ProductServiceImpl implements ProductService,ProductServiceLocal,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4132364370329936994L;
	@PersistenceContext(name="ModuleDatabase")
	private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll() {
		return entityManager.createQuery("select p from Product p").getResultList();
	}

}
