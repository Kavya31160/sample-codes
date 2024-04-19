package com.stackroute.designpattern;

  interface Cake
{
	public void prepareCake();
}

class BaseCake implements Cake
{

	@Override
	public void prepareCake() {
		// TODO Auto-generated method stub
		System.out.println( "Basic Cake without cream");
	}
	
}

abstract class CakeDecorator implements Cake
{
	Cake cakeobj;
	CakeDecorator(Cake cak)
	{
		this.cakeobj=cak;
	}
	public void prepareCake() {
		// TODO Auto-generated method stub
		  cakeobj.prepareCake();
	}
}

class CreamCake extends CakeDecorator
{

	CreamCake(Cake cak) {
		super(cak);
		// TODO Auto-generated constructor stub
	}
	
	public void prepareCake() {
		super.prepareCake();
		System.out.println( "Added Some Cream" );
	}
	
}
class FruitCake extends CakeDecorator
{
	FruitCake(Cake cak)
	{
		super(cak);
	}
	
	public void prepareCake() {
		super.prepareCake();
		System.out.println( "Added Some Fruits" );
	}
}
public class SampleDecorator {

	public static void main(String[] args) {
		 
  Cake mycake=new FruitCake( new CreamCake(new BaseCake()));
  mycake.prepareCake();
  
	}

}
