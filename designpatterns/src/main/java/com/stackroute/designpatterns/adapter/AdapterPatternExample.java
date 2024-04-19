package com.stackroute.designpatterns.adapter;

//Shape is the target interface
//Square is the existing class (Adaptee)
//SquareAdapter is the adapter that implements the Shape interface by delegating 
//the actual drawing to the existing Square class. 
//This way, the Square class can be used in a system that expects objects to implement the Shape interface.

//Target Interface
interface Shape {
 void draw();
}

//Adaptee (Existing class)
class Square {
 void drawSquare() {
     System.out.println("Drawing a square");
 }
}

//Adapter
class SquareAdapter implements Shape {
 private Square square;

 public SquareAdapter(Square square) {
     this.square = square;
 }

 @Override
 public void draw() {
     square.drawSquare();
 }
}

//Client Code
public class AdapterPatternExample {
 public static void main(String[] args) {
     // Using the Square as a Shape using the Adapter
     Square square = new Square();
     Shape squareAdapter = new SquareAdapter(square);

     // Drawing using the adapted interface
     squareAdapter.draw();
 }
}

