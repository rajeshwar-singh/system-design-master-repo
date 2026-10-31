package com.example.demo.designPattern.decoratorDesignPattern.toppings;

import com.example.demo.designPattern.decoratorDesignPattern.pizza.BasePizza;

public class VeggiesTopping extends ToppingDecorator {

    public VeggiesTopping(BasePizza basePizza)
    {
        super(basePizza);
    }
    
    @Override
    public String getDescription()
    {
        return basePizza.getDescription() + "Veggies";
    }

    @Override 
    public double getCost()
    {
        return basePizza.getCost() + 19.67;
    }
}
