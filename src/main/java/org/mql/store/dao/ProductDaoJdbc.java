package org.mql.store.dao;

import java.util.List;
import java.util.Vector;

import org.mql.store.jdbc.Database;
import org.mql.store.models.Product;

public class ProductDaoJdbc implements ProductDao{

	private Database db;
	private String tablename = "Products";
	
	public ProductDaoJdbc(Database db) {
		this.db = db;
	}

	
	public List<Product> selectAll() {
		
		return null;
	}

}
