package org.mql.store.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Database {

	private DataSource dataSource;
	private Connection db;
	
	public Database() {
		
	}
	
	public Database(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		db= dataSource.getConnection();
	}


	public String[][] executeSelect(String query) {
		try {
			Statement sql = db.createStatement();
			ResultSet rs =  sql.executeQuery(query);
			
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			
			ResultSetMetaData rsm = rs.getMetaData();
			
			int cols = rsm.getColumnCount();
		
			String data [][] = new String[rows +1][cols];
			
			for (int i = 0; i < cols; i++) {
				data[0][i] = rsm.getColumnName(i+1);
			}
			int row = 0;
			while (rs.next()) {
				row++;
				for (int i = 0; i < cols; i++) {
					data[row][i] = rs.getString(i + 1);
					
				}
			}
			rs.close();
			return data;
			
		} catch (Exception e) {
			System.out.println("Erreur" + e);
			return null;
		}
		
	}
	
	public String[][] select(String tablename){
		return executeSelect("SELECT * FROM " + tablename);
	}
	
	
	//search in field 
	public String[][] search(String tablename, String field, Object keyword){
		String query = "SELECT * FROM " + tablename 
				+ " WHERE " + field + " LIKE '%" + keyword + "%'";
		return executeSelect(query);
	}
	
	public int insert(String tableName, Object ...row) {
		StringBuffer sb = new StringBuffer("INSERT INTO "
				+ tableName
				+ " VALUES('" + row[0] + "'");
		for (int i = 1; i < row.length; i++) {
			sb.append(", '" + row[i] + "'");
		}
		sb.append(")");
		try {
			Statement sql = db.createStatement();
			//System.out.println("Ajouter");
			return sql.executeUpdate(sb.toString());
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return 0;
		}
	}
	
	
	
	
	
	public int insert(String tablename, Object row) {
		
		return 0;
	}
	
}
