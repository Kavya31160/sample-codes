package com.stackroute.JavaBasedcore;

public class Product {

	String prodcutName;
	int price;
	
	@Override
	public String toString() {
		return "Product [prodcutName=" + prodcutName + ", price=" + price + "]";
	}
	public String getProdcutName() {
		return prodcutName;
	}
	public void setProdcutName(String prodcutName) {
		this.prodcutName = prodcutName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
