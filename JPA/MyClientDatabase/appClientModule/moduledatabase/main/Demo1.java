package moduledatabase.main;

import javax.naming.Context;

import moduledatabase.entities.Product;
import moduledatabase.services.ProductService;

public class Demo1 {

	public static void main(String[] args) {
		try {
			Context context = ClientUtility.getInitialContext();
			ProductService productService = (ProductService)context.lookup("moduledatabase.services.ProductService#moduledatabase.services.ProductService");
			Product newProduct = new Product();
			newProduct.setName("ProductOne");
			newProduct.setPrice(18.5);
			newProduct.setQuantity(24);
			newProduct.setStatus(true);
			productService.createProduct(newProduct);
			System.out.println("product List");
		for(Product product: productService.findAll()) {
			System.out.println("Id: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Price: " + product.getPrice());
			System.out.println("Quantity: " + product.getQuantity());
			System.out.println("Status: " + product.isStatus());
			System.out.println("=================================");
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
