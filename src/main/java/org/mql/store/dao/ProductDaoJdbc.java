package org.mql.store.dao;

import java.util.List;
import java.util.Vector;

import org.mql.store.dao.mapping.StoreMapper;
import org.mql.store.jdbc.Database;
import org.mql.store.models.Product;

public class ProductDaoJdbc implements ProductDao{

	private Database db;
	private String tablename = "product";
	
	public ProductDaoJdbc(Database db) {
		this.db = db;
		
	}
	public List<Product> selectProducts(String name){
		String data[][] = db.select(tablename,"name",name);
		Vector<Product> products = new Vector<Product>();
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		for (int i = 0; i < data.length; i++) {
			products.add(StoreMapper.getProduct(data[i]));
		}
		return products;
	} 
	
	public List<Product> selectAll() {
		String data[][] = db.select(tablename);
		Vector<Product> products = new Vector<Product>();
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
		for (int i = 0; i < data.length; i++) {
			products.add(StoreMapper.getProduct(data[i]));
		}
		return products;
	}

}
