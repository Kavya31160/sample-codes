package com.stackroute.designpattern;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface FoodItem {
    void serve(String tableNumber);
}

// Concrete Flyweight
class ConcreteFoodItem implements FoodItem {
    private String name;

    public ConcreteFoodItem(String name) {
        this.name = name;
    }

    @Override
    public void serve(String tableNumber) {
        System.out.println("Serving " + name + " to table " + tableNumber);
    }
}

// Flyweight Factory
class FoodItemFactory {
    private Map<String, FoodItem> foodItems;

    public FoodItemFactory() {
        this.foodItems = new HashMap<>();
    }

    public FoodItem getFoodItem(String name) {
        if (!foodItems.containsKey(name)) {
            foodItems.put(name, new ConcreteFoodItem(name));
        }
        return foodItems.get(name);
    }
}



public class SampleFlyweight {

	public static void main(String[] args) {
	       FoodItemFactory foodItemFactory = new FoodItemFactory();

	        // Order 1
	        FoodItem burger1 = foodItemFactory.getFoodItem("Burger");
	        burger1.serve("Table 1");

	        FoodItem fries1 = foodItemFactory.getFoodItem("Fries");
	        fries1.serve("Table 1");

	        // Order 2
	        FoodItem burger2 = foodItemFactory.getFoodItem("Burger");
	        burger2.serve("Table 2");

	        FoodItem coke1 = foodItemFactory.getFoodItem("Coke");
	        coke1.serve("Table 2");

	}

}
