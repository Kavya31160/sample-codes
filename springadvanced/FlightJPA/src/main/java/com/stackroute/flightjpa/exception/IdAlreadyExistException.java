package com.stackroute.flightjpa.exception;

public class IdAlreadyExistException extends  RuntimeException{

	public IdAlreadyExistException(String s)
	{
		super(s);
	}
}
