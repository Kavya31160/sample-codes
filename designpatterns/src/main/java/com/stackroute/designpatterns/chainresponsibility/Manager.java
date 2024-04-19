package com.stackroute.designpatterns.chainresponsibility;

public class Manager extends RequestHandler{
	
    public Manager(){
        super("manager");
    }
    @Override
    void setNext(RequestHandler nextHandler){
        this.nextHandler=nextHandler;
    }
    @Override
    void approve(int id){
        if(id>=1 && id<=20)
        {
            System.out.println("Request Approved by Manager");
        }
        else{
            super.approve(id);
        }
    }
}
