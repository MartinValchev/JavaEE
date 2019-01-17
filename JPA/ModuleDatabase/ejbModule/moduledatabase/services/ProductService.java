package moduledatabase.services;

import java.util.List;

import javax.ejb.Remote;

import moduledatabase.entities.Product;

@Remote
public interface ProductService {
	public List<Product> findAll();
}
