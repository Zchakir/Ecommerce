package org.mql.store.models;

public class Product {
	
	private String id_ref;
	private String name;
	private String image;
	private double price;
	
	public Product(String id_ref, String name, String image, double price) {
		super();
		this.id_ref = id_ref;
		this.name = name;
		this.image = image;
		this.price = price;
	}

	public Product() {
		super();
	}

	public String getId_ref() {
		return id_ref;
	}

	public void setId_ref(String id_ref) {
		this.id_ref = id_ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id_ref=" + id_ref + ", name=" + name + ", image=" + image + ", price=" + price + "]";
	}
	
	
	
	
	

	

}
