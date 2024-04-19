package com.stackroute.designpatterns.chainresponsibility;

public class SeniorManager extends RequestHandler{
    public SeniorManager(){
        super("Senior manager");
    }
    @Override
    void setNext(RequestHandler nextHandler){
        this.nextHandler=nextHandler;
    }
    @Override
    void approve(int id){
        if(id>=21 && id<=40)
            {
            System.out.println("Request Approved by Senior Manager");
        }
        else{
            super.approve(id);
        }
    }
}
