package com.stackroute.JavaBasedcore;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class Bill implements InitializingBean,DisposableBean  {

	String billno;
	String customerName;
	
	
	@Autowired
	List<Product> products;
	
	
	
	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Bill [billno=" + billno + ", customerName=" + customerName + ", product=" + products + "]";
	}
	
	
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public void destroy() throws Exception {
		System.out.println("After Destroy");
		
	}


	public void afterPropertiesSet() throws Exception {
		System.out.println(" Bill bean instantiated ");
		
	}

	
	
	
	
}
