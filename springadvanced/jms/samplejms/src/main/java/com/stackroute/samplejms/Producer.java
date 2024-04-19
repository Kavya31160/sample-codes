package com.stackroute.samplejms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	
	
 
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

	            // Create a message producer
	            MessageProducer producer = session.createProducer(destination);

	            // Create a text message
	            TextMessage message = session.createTextMessage("today is Friday");

	            // Send the message
	            producer.send(message);

	            // Close resources
	            producer.close();
	            session.close();
	            connection.close();
	            System.out.println("Sent message from producer");
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	    }
	}
 



