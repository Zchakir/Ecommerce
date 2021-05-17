package org.mql.store.web;

import javax.servlet.http.HttpServletRequest;

import org.mql.store.models.Product;


public class ParametersResolver {

	private HttpServletRequest request;
	
	public ParametersResolver(HttpServletRequest request) {
		this.request= request;
		
	}
	
	public String get(String param) {
		return request.getParameter(param);
	}

	
	public  int getDouble(String param) {
		try {
			return (int) Double.parseDouble(request.getParameter(param));
			
		} catch (Exception e) {
			return 0;
		}
	}
	
	public  Product getAuthor() {
		return new Product(get("id_ref"), get("name"), get("image"), getDouble("price"));
	}
	
	public String getKeyword() {
		return get("keyword");
	}
}
