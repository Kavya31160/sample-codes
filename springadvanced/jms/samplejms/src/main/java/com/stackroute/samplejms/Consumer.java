package com.stackroute.samplejms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {
	
	   public static void main(String[] args) {
	        try {
	            // Create a connection factory
	            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

	            // Create a connection
	            Connection connection = connectionFactory.createConnection();
	            connection.start();

	            // Create a session
	            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

	            // Create a destination (queue or topic)
	            Destination destination = session.createQueue("MyQueue");

	            // Create a message consumer
	            MessageConsumer consumer = session.createConsumer(destination);

	            // Set up a message listener
	            consumer.setMessageListener(message -> {
	                if (message instanceof TextMessage) {
	                    try {
	                        System.out.println("Received message: " + ((TextMessage) message).getText());
	                    } catch (JMSException e) {
	                        e.printStackTrace();
	                    }
	                }
	            });

	            // Keep the program running to receive messages
	            System.out.println("Waiting for messages. Press Ctrl+C to exit.");
	            Thread.sleep(100000);

	            // Close resources
	            consumer.close();
	            session.close();
	            connection.close();
	        } catch (JMSException | InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

}
