package org.mql.store.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
	
	private String driver;
	private String bridge ;
	private String host;
	private String source;
	private String username;
	private String password;
	
	public DataSource() {
		
	}

	public DataSource(String driver, String bridge, String host, String source, String username, String password) {
		super();
		this.driver = driver;
		this.bridge = bridge;
		this.host = host;
		this.source = source;
		this.username = username;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			String url = bridge + "//"+ host + "/" + source;
			return DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			return null;
		}

	}
	

}
