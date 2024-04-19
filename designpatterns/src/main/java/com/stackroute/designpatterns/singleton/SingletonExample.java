package com.stackroute.designpatterns.singleton;

import java.util.List;

//Logger class is a singleton that allows logging messages. 
//The LoggingExample class demonstrates how to use the singleton logger to log messages and retrieve them later. 
//The Logger class ensures that only one instance exists, and the log messages are accumulated in a list.

// Example usage
public class SingletonExample {
    public static void main(String[] args) {
        // Get the singleton instance of the logger
        Logger logger = Logger.getInstance();

        // Log some messages
        logger.logMessage("Info: Application started");
        logger.logMessage("Warning: Disk space low");
        logger.logMessage("Error: Null pointer exception");

        // Get and print all log messages
        List<String> logMessages = logger.getLogMessages();
        for (String message : logMessages) {
            System.out.println(message);
        }
    }
}
