package org.mql.store.web;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mql.store.web.actions.ActionFactory;
import org.mql.store.web.actions.ProductAction;


public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String prefix;
	private String suffix;
	private String source;

	private ProductAction productAction;
	
    public void init() throws ServletException {

    	source = getInitParameter("source");
    	prefix = getServletContext().getInitParameter("prefix");
    	suffix = getServletContext().getInitParameter("suffix");
    	
    	ActionFactory factory = ActionFactory.getDefaultActionFactory(source);
    	productAction = factory.getProductAction();
    	
    	System.out.println("prefix = " + prefix);
    	System.out.println("suffix = " + suffix);
    	System.out.println("source = " + source);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ParametersResolver params = new ParametersResolver(request);
		int i = request.getRequestURI().lastIndexOf("/") + 1;
		String action = request.getRequestURI().substring(i);
		System.out.println(action);
		
		String view = "Error";
		Object model = "service Non disponible";
		
		if (action.equals("ProductsList")) {
			view = productAction.productsList();
			model = productAction.getProducts();
		}
		
		request.setAttribute("model", model);
		request.getRequestDispatcher(prefix + view + suffix).forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
