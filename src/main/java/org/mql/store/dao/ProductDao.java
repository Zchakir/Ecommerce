package org.mql.store.dao;

import java.util.List;

import org.mql.store.models.Product;

public interface ProductDao { 
	
	public List<Product> selectAll(); 
	public List<Product> selectProducts(String name); 

}
