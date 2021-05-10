package org.mql.store.dao.mapping;

import org.mql.store.models.Product;

public class StoreMapper {

	public StoreMapper() {
		
	}
	
	public static Product getProduct(String ...row) {
		return new Product(row[0], row[1],row[2] , getDouble(row[3]));
		
	}
	
	public static int getInt(String value, int defaultValue) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			return defaultValue;
		}
	}
	
	public static int getInt(String value) {
		return getInt(value, 0);
	}
	
	
	public static int getDouble(String value, int defaultValue) {
		try {
			return (int) Double.parseDouble(value);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			return defaultValue;
		}
	}
	
	public static int getDouble(String value) {
		return getInt(value, 0);
	}
}
