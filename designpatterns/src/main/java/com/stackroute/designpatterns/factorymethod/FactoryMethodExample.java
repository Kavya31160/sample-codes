package com.stackroute.designpatterns.factorymethod;


//Document interface is the product interface, 
//PDFDocument and WordDocument are concrete products. 
//The DocumentFactory interface is the creator interface
//PDFDocumentFactory and WordDocumentFactory are concrete creators. 
//The client code can use different factories to create different types of documents 
//without knowing the specific implementation details of each document.

//Document interface
interface Document {
 void open();
 void save();
}

//Concrete Document - PDFDocument
class PDFDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening PDF document");
     // PDF-specific logic
 }

 @Override
 public void save() {
     System.out.println("Saving PDF document");
     // PDF-specific save logic
 }
}

//Concrete Document - WordDocument
class WordDocument implements Document {
 @Override
 public void open() {
     System.out.println("Opening Word document");
     // Word-specific logic
 }

 @Override
 public void save() {
     System.out.println("Saving Word document");
     // Word-specific save logic
 }
}

//DocumentFactory interface
interface DocumentFactory {
 Document createDocument();
}

//Concrete DocumentFactory - PDFDocumentFactory
class PDFDocumentFactory implements DocumentFactory {
 @Override
 public Document createDocument() {
     return new PDFDocument();
 }
}

//Concrete DocumentFactory - WordDocumentFactory
class WordDocumentFactory implements DocumentFactory {
 @Override
 public Document createDocument() {
     return new WordDocument();
 }
}

//Client code
public class FactoryMethodExample {
 public static void main(String[] args) {
     // Creating a PDF document using PDFDocumentFactory
     DocumentFactory pdfFactory = new PDFDocumentFactory();
     Document pdfDocument = pdfFactory.createDocument();
     pdfDocument.open(); // Output: Opening PDF document
     pdfDocument.save(); // Output: Saving PDF document

     // Creating a Word document using WordDocumentFactory
     DocumentFactory wordFactory = new WordDocumentFactory();
     Document wordDocument = wordFactory.createDocument();
     wordDocument.open(); // Output: Opening Word document
     wordDocument.save(); // Output: Saving Word document
 }
}
