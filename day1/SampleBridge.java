package com.stackroute.designpattern;

//Implementor interface
interface Color {
 void fill();
}

//ConcreteImplementor classes
class RedColor implements Color {
 public void fill() {
     System.out.println("Applying red color");
 }
}

class GreenColor implements Color {
 public void fill() {
     System.out.println("Applying green color");
 }
}

//Abstraction interface
abstract class Shape {
 // Composition - implementor
 protected Color color;

 public Shape(Color color) {
     this.color = color;
 }

 abstract void applyColor();
}

//RefinedAbstraction classes
class Square extends Shape {
 public Square(Color color) {
     super(color);
 }

 @Override
 void applyColor() {
     System.out.print("Square with ");
     color.fill();
 }
}

class Circle extends Shape {
 public Circle(Color color) {
     super(color);
 }

 @Override
 void applyColor() {
     System.out.print("Circle with ");
     color.fill();
 }
}

 

public class SampleBridge {

	public static void main(String[] args) {
		 Color redColor = new RedColor();
	     Color greenColor = new GreenColor();

	     Shape redSquare = new Square(greenColor);
	     Shape greenCircle = new Circle(greenColor);

	     redSquare.applyColor(); // Output: Square with Applying red color
	     greenCircle.applyColor(); // Output: Circle with Applying green color

	}

}
