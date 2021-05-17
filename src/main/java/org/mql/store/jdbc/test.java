package org.mql.store.jdbc;


public class test {

	public test() {
		exp01();
	}
	
	
	public void print(String data[][], int start, int count) {
		for (int i = 0; i < data[0].length; i++) {
			System.out.print(data[0][i] +" - ");
		}
		System.out.println();
		if (start + count > data.length) count = data.length - start ;
		for (int i = start; i < start + count; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + " - ");
			}
			System.out.println();
		}
		
	}
	
	public void print(String data[][]) {
		print(data, 1, data.length-1);

	}
	public void exp01() {
		DataSource ds = new MySQLDataSource("productstore");
		Database db = new Database(ds);
		String data[][] = db.select("product");
		print(data, 1 , 10);
	}
	

	

	

	
	public static void main(String[] args) {
		new test();

	}

}
