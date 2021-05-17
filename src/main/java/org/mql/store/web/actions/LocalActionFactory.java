package org.mql.store.web.actions;

import org.mql.store.business.StoreService;
import org.mql.store.business.StoreServiceDefault;
import org.mql.store.dao.ProductDao;
import org.mql.store.dao.ProductDaoJdbc;
import org.mql.store.jdbc.DataSource;
import org.mql.store.jdbc.Database;
import org.mql.store.jdbc.MySQLDataSource;

public class LocalActionFactory extends ActionFactory {
	private ProductAction productAction;
	
	public LocalActionFactory(String source) {
		// Wiring :
		DataSource ds = new MySQLDataSource(source);
		Database db = new Database(ds);
		ProductDao productdao = new ProductDaoJdbc(db);
		
		StoreService service = new StoreServiceDefault(productdao);
		
		productAction = new ProductAction(service);
	}

	public ProductAction getProductAction() {
		return productAction;
	}

	
	

}
