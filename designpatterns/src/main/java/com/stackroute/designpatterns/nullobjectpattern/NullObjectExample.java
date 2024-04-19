package com.stackroute.designpatterns.nullobjectpattern;

//Interface representing a Logger
interface Logger {
 void log(String message);
}

//Concrete implementation of Logger
class ConsoleLogger implements Logger {
 @Override
 public void log(String message) {
     System.out.println("Console Log: user logged in " + message);
 }
}

//Null Object implementation for Logger
class NullLogger implements Logger {
 @Override
 public void log(String message) {
	 System.out.println("user details are null");
 }
}

//Client code using Logger
public class NullObjectExample {
 public static void main(String[] args) {
      
     Logger logger = getLoggerForUser(null);

  
     logger.log(null);

 }

 // Factory method to get a Logger based on user
 private static Logger getLoggerForUser(String username) {
  
     if ("mary.rani".equals(username)) {
         return new ConsoleLogger();
     } else {
         return new NullLogger();
     }
 }
}

