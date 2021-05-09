package org.mql.store.jdbc;

public class MySQLDataSource extends DataSource {
	
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	
	
	public MySQLDataSource(String host, String source, String username, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, host, source, username, password);
		
	}
	
	public MySQLDataSource(String source, String username, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, username, password);
		
	}
	
	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", source, "root", "");
		
	}
	
	public MySQLDataSource() {
		super(MYSQL_DRIVER, MYSQL_BRIDGE, "localhost", "", "root", "");
		
	}


	

}
