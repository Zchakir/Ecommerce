package org.mql.store.business;

import java.util.List;

import org.mql.store.dao.ProductDao;
import org.mql.store.models.Product;

public class StoreServiceDefault  implements StoreService{

	private ProductDao productdao;
	
	public StoreServiceDefault(ProductDao productdao) {
		this.productdao = productdao;
	}

	
	public List<Product> getProducts() {
		return null;
	}

}
