package org.mql.store.dao;

import java.util.List;
import java.util.Vector;

import org.mql.store.dao.mapping.StoreMapper;
import org.mql.store.jdbc.Database;
import org.mql.store.models.Product;

public class ProductDaoJdbc implements ProductDao{

	private Database db;
	private String tablename = "Product";
	
	public ProductDaoJdbc(Database db) {
		this.db = db;
	}

	
	public List<Product> selectAll() {
		String data[][] = db.select(tablename);
		Vector<Product> products = new Vector<Product>();
		for (int i = 1; i < data.length; i++) {
			products.add(StoreMapper.getProduct(data[i]));
		}
		return products;
	}

}
