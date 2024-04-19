package com.stackroute.designpatterns.mediator;

import java.util.ArrayList;
import java.util.List;

//ChatMediator is the mediator interface.

//ChatMediatorImpl is the concrete mediator that coordinates communication between users.

//User is the colleague interface representing users in the chat.
//ChatUser is the concrete colleague that sends and receives messages through the mediator.
//The client creates a mediator and users, adds users to the mediator, 
//and demonstrates communication through the mediator.

// Mediator interface
interface ChatMediator {
    void sendMessage(String message, User user);
    void addUser(User user);
}

// Concrete Mediator
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            // Send the message to all users except the sender
            if (u != user) {
                u.receiveMessage(message);
            }
        }
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }
}

// Colleague interface
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}

// Concrete Colleague
class ChatUser extends User {
	
    public ChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " receives: " + message);
    }
}

// Client
public class MediatorExample {
    public static void main(String[] args) {
        ChatMediator mediator = new ChatMediatorImpl();

        User user1 = new ChatUser(mediator, "User 1");
        User user2 = new ChatUser(mediator, "User 2");
        User user3 = new ChatUser(mediator, "User 3");

        mediator.addUser(user1);
        mediator.addUser(user2);
        mediator.addUser(user3);

        user2.sendMessage("Hello, everyone!");

    }
}
