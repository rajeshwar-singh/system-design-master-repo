package com.example.demo.designPattern.decoratorDesignPattern;

import com.example.demo.designPattern.decoratorDesignPattern.pizza.*;
import com.example.demo.designPattern.decoratorDesignPattern.toppings.*;

public class PizzaShop {
    public void start()
    {
        System.out.println("---- Decorator Design Pattern Started ----");

        BasePizza pizza1 = new CheeseNCornPizza();
        System.out.println("Order 1: " + pizza1.getDescription() 
            + " : Rs. " + pizza1.getCost());

        BasePizza pizza2 = new ExtraChesseTopping(new CheeseNCornPizza());
        System.out.println("Order 2: "+ pizza2.getDescription() 
            + " : Rs. " + pizza2.getCost());

        BasePizza pizza3 = new PannerTopping(new VeggieFeastPizza());
        System.out.println("Order 3: "+ pizza3.getDescription() 
            + " : Rs. " + pizza3.getCost());
    
        BasePizza pizza4 = new VeggiesTopping(new FarmhousePizza());
        System.out.println("Order 4: "+ pizza4.getDescription() 
            + " : Rs. " + pizza4.getCost());

        BasePizza pizza5 = new ExtraChesseTopping(new PannerTopping(new CheeseNCornPizza()));
        System.out.println("Order 5: "+ pizza5.getDescription() 
            + " : Rs. " + pizza5.getCost());



    }
}
