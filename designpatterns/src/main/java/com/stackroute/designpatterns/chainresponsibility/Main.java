package com.stackroute.designpatterns.chainresponsibility;

public class Main {
	
	public static void main(String[] args) {
		
		RequestHandler manager = new Manager();
		
		
		RequestHandler seniorManager = new SeniorManager();
		
		RequestHandler director = new Director();
		
		
	manager.setNext(seniorManager);
		
		
		//seniorManager.setNext(director);
		
		manager.approve(29);
		
		
//	manager.approve(90);
//		
//		director.approve(19);
		
	}
}