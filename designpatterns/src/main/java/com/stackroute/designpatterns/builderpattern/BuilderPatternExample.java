package com.stackroute.designpatterns.builderpattern;

//Product - Computer
class Computer {
 private String CPU;
 private String RAM;
 private String storage;
 private String graphicsCard;

 // Private constructor to enforce the use of the builder
 private Computer(ComputerBuilder builder) {
     this.CPU = builder.CPU;
     this.RAM = builder.RAM;
     this.storage = builder.storage;
     this.graphicsCard = builder.graphicsCard;
 }

 // Getter methods

 @Override
 public String toString() {
     return "Computer{" +
             "CPU='" + CPU + '\'' +
             ", RAM='" + RAM + '\'' +
             ", storage='" + storage + '\'' +
             ", graphicsCard='" + graphicsCard + '\'' +
             '}';
 }

 // Builder Class
 static class ComputerBuilder {
     private String CPU;
     private String RAM;
     private String storage;
     private String graphicsCard;

     // Constructor with mandatory parameters
     public ComputerBuilder(String CPU, String RAM, String storage) {
         this.CPU = CPU;
         this.RAM = RAM;
         this.storage = storage;
     }

     // Optional parameters with setter methods
     public ComputerBuilder setGraphicsCard(String graphicsCard) {
         this.graphicsCard = graphicsCard;
         return this;
     }

     // Build method to create the final Computer object
     public Computer build() {
         return new Computer(this);
     }
 }
}

//Client Code
public class BuilderPatternExample {
 public static void main(String[] args) {
     // Creating a computer using the builder pattern
     Computer computer = new Computer.ComputerBuilder("Intel i7", "16GB", "512GB SSD")
             .setGraphicsCard("NVIDIA GeForce RTX 3070")
             .build();

     // Displaying the computer details
     System.out.println(computer);
 }
}
