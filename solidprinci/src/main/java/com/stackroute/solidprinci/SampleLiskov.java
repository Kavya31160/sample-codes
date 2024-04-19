package com.stackroute.solidprinci;


//Bird is a superclass
class Bird {
 // Common properties and methods for all birds
 protected String name;

 public Bird(String name) {
     this.name = name;
 }

 public void fly() {
     System.out.println(name + " is flying.");
 }
}

//Sparrow is a subclass of Bird
class Sparrow extends Bird {
 public Sparrow(String name) {
     super(name);
 }

 // Additional methods specific to Sparrow
 public void chirp() {
     System.out.println(name + " is chirping.");
 }
}

//Ostrich is a subclass of Bird
class Ostrich extends Bird {
 public Ostrich(String name) {
     super(name);
 }

 
 @Override
 public void fly() {
     System.out.println(name + " can't fly.");
 }
 
}

//Client code
public class SampleLiskov {
 public static void main(String[] args) {
     Bird sparrow = new Sparrow("Sparrow");
     sparrow.fly();  // Output: Sparrow is flying.
      
     Bird ostrich = new Ostrich("Ostrich");
     ostrich.fly();  // Output: Ostrich can't fly.
     
 }
}