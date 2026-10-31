package com.example.demo.designPattern.decoratorDesignPattern.toppings;

import com.example.demo.designPattern.decoratorDesignPattern.pizza.BasePizza;

public class ExtraChesseTopping extends ToppingDecorator {

    public ExtraChesseTopping(BasePizza basePizza)
    {
        super(basePizza);
    }

    @Override 
    public String getDescription()
    {
        return basePizza.getDescription() + "Extra Cheese";
    }

    @Override
    public double getCost()
    {
        return basePizza.getCost() + 29.99;
    }
    
}
