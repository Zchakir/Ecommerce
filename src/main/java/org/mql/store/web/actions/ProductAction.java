package org.mql.store.web.actions;

import java.util.List;

import org.mql.store.business.StoreService;
import org.mql.store.models.Product;


public class ProductAction {
	
	private StoreService service;
	
	private List<Product> products;
	private String message;
	
	public ProductAction() {
	}

	public ProductAction(StoreService service) {
		super();
		this.service = service;
	}

	public void setService(StoreService service) {
		this.service = service;
	}
	
	public String productsList() {
		products = service.getProducts();
		return "ProductsList";
	}
	
	
	public List<Product> getProducts() {
		return products;
	}
	
	public String getMessage() {
		return message;
	}
}
