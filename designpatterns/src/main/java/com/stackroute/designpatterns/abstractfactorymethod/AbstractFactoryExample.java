package com.stackroute.designpatterns.abstractfactorymethod;

//Abstract Product - Button
interface Button {
 void render();
}

//Concrete Product - LightButton
class LightButton implements Button {
 @Override
 public void render() {
     System.out.println("Rendering Light Button");
     // Light theme button rendering logic
 }
}

//Concrete Product - DarkButton
class DarkButton implements Button {
 @Override
 public void render() {
     System.out.println("Rendering Dark Button");
     // Dark theme button rendering logic
 }
}

//Abstract Product - TextField
interface TextField {
 void render();
}

//Concrete Product - LightTextField
class LightTextField implements TextField {
 @Override
 public void render() {
     System.out.println("Rendering Light TextField");
     // Light theme text field rendering logic
 }
}

//Concrete Product - DarkTextField
class DarkTextField implements TextField {
 @Override
 public void render() {
     System.out.println("Rendering Dark TextField");
     // Dark theme text field rendering logic
 }
}

//Abstract Factory
interface UIFactory {
 Button createButton();
 TextField createTextField();
}

//Concrete Factory - LightThemeFactory
class LightThemeFactory implements UIFactory {
 @Override
 public Button createButton() {
     return new LightButton();
 }

 @Override
 public TextField createTextField() {
     return new LightTextField();
 }
}

//Concrete Factory - DarkThemeFactory
class DarkThemeFactory implements UIFactory {
 @Override
 public Button createButton() {
     return new DarkButton();
 }

 @Override
 public TextField createTextField() {
     return new DarkTextField();
 }
}

//Client Code
public class AbstractFactoryExample {
 public static void main(String[] args) {
     // Creating a light theme UI
     UIFactory lightFactory = new LightThemeFactory();
     Button lightButton = lightFactory.createButton();
     lightButton.render(); // Output: Rendering Light Button

     TextField lightTextField = lightFactory.createTextField();
     lightTextField.render(); // Output: Rendering Light TextField

     // Creating a dark theme UI
     UIFactory darkFactory = new DarkThemeFactory();
     Button darkButton = darkFactory.createButton();
     darkButton.render(); // Output: Rendering Dark Button

     TextField darkTextField = darkFactory.createTextField();
     darkTextField.render(); // Output: Rendering Dark TextField
 }
}
