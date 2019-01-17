package moduledatabase.services;

import java.util.List;

import javax.ejb.Local;

import moduledatabase.entities.Product;

@Local
public interface ProductServiceLocal {
	public List<Product> findAll();
}