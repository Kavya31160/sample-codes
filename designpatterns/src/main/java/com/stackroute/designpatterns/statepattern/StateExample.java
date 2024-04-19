package com.stackroute.designpatterns.statepattern;

//VendingMachine is the context class whose behavior changes based on its internal state.

//VendingMachineState is the state interface defining the interface for concrete states.
//NoCoinsState, HasCoinsState, and ItemSelectedState are concrete state classes 
//representing different states of the vending machine.

//The client code demonstrates the vending machine's behavior changing based on its state, 
//such as inserting a coin, selecting an item, and dispensing the item.

//State interface - defines the interface for concrete states
interface VendingMachineState {
	void insertCoin();

	void selectItem();

	void dispenseItem();
}


//Context class - the object whose behavior changes
class VendingMachine {
	
	private VendingMachineState currentState;

	public VendingMachine() {
		// Initial state is no coins
		currentState = new NoCoinsState(this);
	}

	public void setState(VendingMachineState state) {
		this.currentState = state;
	}

	public void insertCoin() {
		currentState.insertCoin();
	}

	public void selectItem() {
		currentState.selectItem();
	}

	public void dispenseItem() {
		currentState.dispenseItem();
	}
}


//Concrete State classes
class NoCoinsState implements VendingMachineState {
	private final VendingMachine vendingMachine;

	public NoCoinsState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("Coin inserted");
		vendingMachine.setState(new HasCoinsState(vendingMachine));
	}

	@Override
	public void selectItem() {
		System.out.println("Please insert a coin first");
	}

	@Override
	public void dispenseItem() {
		System.out.println("Please insert a coin first");
	}
}

class HasCoinsState implements VendingMachineState {
	private final VendingMachine vendingMachine;

	public HasCoinsState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("Coin already inserted");
	}

	@Override
	public void selectItem() {
		System.out.println("Item selected");
		vendingMachine.setState(new ItemSelectedState(vendingMachine));
	}

	@Override
	public void dispenseItem() {
		System.out.println("Please select an item first");
	}
}

class ItemSelectedState implements VendingMachineState {
	private final VendingMachine vendingMachine;

	public ItemSelectedState(VendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("Coin already inserted");
	}

	@Override
	public void selectItem() {
		System.out.println("Item already selected");
	}

	@Override
	public void dispenseItem() {
		System.out.println("Item dispensed");
		vendingMachine.setState(new NoCoinsState(vendingMachine));
	}
}

//Client code
public class StateExample {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();

		// Insert a coin
	//	vendingMachine.insertCoin();

		// Try to dispense item without selecting
		vendingMachine.dispenseItem();

		// Select an item
		//vendingMachine.selectItem();

		// Dispense the selected item
		//vendingMachine.dispenseItem();
	}
}
