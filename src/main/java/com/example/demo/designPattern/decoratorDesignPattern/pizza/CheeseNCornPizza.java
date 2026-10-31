package com.example.demo.designPattern.decoratorDesignPattern.pizza;

public class CheeseNCornPizza implements BasePizza
{
    @Override 
    public String getDescription()
    {
        return "Cheese N Corn Pizza";
    }

    @Override 
    public double getCost()
    {
        return 159.99;
    }
}