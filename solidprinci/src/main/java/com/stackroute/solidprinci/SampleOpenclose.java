package com.stackroute.solidprinci;

abstract class FoodType
{
	public abstract void display();
}
//closed for modification and open for extension
class Canteen
{
	
	FoodType foodtype;
	
		Canteen(FoodType ftype)
		{
			foodtype=ftype;
		}
		
	 void displayMenu()
	 {
		  System.out.println("Food Details");
		  foodtype.display();
		 
	 }
	}

class Snack extends FoodType
{

	@Override
	public void display() {
	System.out.println("chips are available and Juice");
		
	}
	
}

class Breakfast extends FoodType
{

	@Override
	public void display() {
		System.out.println("Bread Toast");
		
	}
	
}

class Dinner extends FoodType
{

	@Override
	public void display() {
		System.out.println("Chapathi");
		
	}
	
}




public class SampleOpenclose {

	public static void main(String[] args) {
		Canteen canteen;
		
		FoodType ftype=new Snack();
		
		canteen=new Canteen(ftype);
		
		ftype.display();
		
		FoodType ftype1=new Breakfast();
		 canteen=new Canteen(ftype1);
		
		 ftype1.display();
		 
		 FoodType ftype2=new Dinner();
		 canteen=new Canteen(ftype2);
		 
		
		 ftype2.display();
		
		 
		
	}

}
