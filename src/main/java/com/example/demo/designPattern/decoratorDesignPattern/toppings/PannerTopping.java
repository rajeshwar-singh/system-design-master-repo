package com.example.demo.designPattern.decoratorDesignPattern.toppings;

import com.example.demo.designPattern.decoratorDesignPattern.pizza.BasePizza;

public class PannerTopping extends ToppingDecorator{
    public PannerTopping(BasePizza basePizza)
    {
        super(basePizza);
    }

    @Override 
    public String getDescription()
    {
        return basePizza.getDescription() + "Panner";
    }

    @Override
    public double getCost()
    {
        return basePizza.getCost() + 39.99;
    }
    
}
