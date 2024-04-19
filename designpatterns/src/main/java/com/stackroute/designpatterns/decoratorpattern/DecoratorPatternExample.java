package com.stackroute.designpatterns.decoratorpattern;

//Coffee is the component interface
//SimpleCoffee is a concrete component
//MilkDecorator and SugarDecorator are concrete decorators. 
//The decorators dynamically add functionality (description and cost) to the Coffee objects.

//Component Interface
interface Coffee {
 String getDescription();
 double getCost();
}

//Concrete Component
class SimpleCoffee implements Coffee {
 @Override
 public String getDescription() {
     return "Simple Coffee";
 }

 @Override
 public double getCost() {
     return 2.0;
 }
}

//Decorator
abstract class CoffeeDecorator implements Coffee {
 protected Coffee decoratedCoffee;

 public CoffeeDecorator(Coffee decoratedCoffee) {
     this.decoratedCoffee = decoratedCoffee;
 }

 @Override
 public String getDescription() {
     return decoratedCoffee.getDescription();
 }

 @Override
 public double getCost() {
     return decoratedCoffee.getCost();
 }
}

//Concrete Decorator
class MilkDecorator extends CoffeeDecorator {
 public MilkDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 @Override
 public String getDescription() {
     return super.getDescription() + " with Milk";
 }

 @Override
 public double getCost() {
     return super.getCost() + 0.5;
 }
}

//Concrete Decorator
class SugarDecorator extends CoffeeDecorator {
 public SugarDecorator(Coffee decoratedCoffee) {
     super(decoratedCoffee);
 }

 @Override
 public String getDescription() {
     return super.getDescription() + " with Sugar";
 }

 @Override
 public double getCost() {
     return super.getCost() + 0.2;
 }
}

//Client Code
public class DecoratorPatternExample {
 public static void main(String[] args) {
     // Create a simple coffee
     Coffee simpleCoffee = new SimpleCoffee();
     System.out.println("Cost: " + simpleCoffee.getCost() + ", Description: " + simpleCoffee.getDescription());

     // Add milk to the coffee
     Coffee milkCoffee = new MilkDecorator(simpleCoffee);
     System.out.println("Cost: " + milkCoffee.getCost() + ", Description: " + milkCoffee.getDescription());

     // Add sugar to the coffee
     Coffee sweetCoffee = new SugarDecorator(milkCoffee);
     System.out.println("Cost: " + sweetCoffee.getCost() + ", Description: " + sweetCoffee.getDescription());
 }
}
