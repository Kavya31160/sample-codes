package com.stackroute.designpatterns.command;

//Order is the command interface.
//PizzaOrder and PastaOrder are concrete command classes that encapsulate requests.
//Chef is the receiver, responsible for executing the actual cooking tasks.
//Waiter is the invoker, responsible for taking orders and executing them.

//Command Interface
interface Order {
 void execute();
}

//Concrete Command
class PizzaOrder implements Order {
 private Chef chef;

 public PizzaOrder(Chef chef) {
     this.chef = chef;
 }

 @Override
 public void execute() {
     chef.cookPizza();
 }
}

//Concrete Command
class PastaOrder implements Order {
 private Chef chef;

 public PastaOrder(Chef chef) {
     this.chef = chef;
 }

 @Override
 public void execute() {
     chef.cookPasta();
 }
}

//Receiver
class Chef {
 public void cookPizza() {
     System.out.println("Chef is cooking a pizza!");
 }

 public void cookPasta() {
     System.out.println("Chef is cooking pasta!");
 }
}

//Invoker
class Waiter {
 private Order order;

 public void setOrder(Order order) {
     this.order = order;
 }

 public void takeOrder() {
     order.execute();
 }
}

//Client
public class Restaurant {
 public static void main(String[] args) {
     Chef chef = new Chef();

     Order pizzaOrder = new PizzaOrder(chef);
     Order pastaOrder = new PastaOrder(chef);

     Waiter waiter = new Waiter();

     // Customer places orders
  //   waiter.setOrder(pizzaOrder);
    // waiter.takeOrder(); // Chef is cooking a pizza!

   waiter.setOrder(pastaOrder);
     waiter.takeOrder(); // Chef is cooking pasta!
 }
}
