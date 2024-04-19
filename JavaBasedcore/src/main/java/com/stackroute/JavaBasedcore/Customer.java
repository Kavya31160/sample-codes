package com.stackroute.JavaBasedcore;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {
String customerName;


//@Autowired 
Product product;


public void myInitialMethod()
{
	System.out.println("initial methiod called - this is customer data");
}

@Override
public String toString() {
	return "Customer [customerName=" + customerName + ", product=" + product + "]";
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}

}
