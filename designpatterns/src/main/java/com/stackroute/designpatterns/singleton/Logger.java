package com.stackroute.designpatterns.singleton;

import java.util.ArrayList;
import java.util.List;

//Singleton Logger class
public class Logger {
 // The single instance of the Logger
 private static Logger instance;

 // List to store log messages
 private List<String> logMessages;

 // Private constructor to prevent instantiation from outside the class
 private Logger() {
     logMessages = new ArrayList<>();
 }

 // Public method to provide the single instance of the Logger
 public static Logger getInstance() {
     // Lazy initialization
     if (instance == null) {
         instance = new Logger();
     }
     return instance;
 }

 // Log a message
 public void logMessage(String message) {
     logMessages.add(message);
 }

 // Get all log messages
 public List<String> getLogMessages() {
     return logMessages;
 }
}
