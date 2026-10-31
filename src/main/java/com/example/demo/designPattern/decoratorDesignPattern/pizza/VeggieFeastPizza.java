package com.example.demo.designPattern.decoratorDesignPattern.pizza;

public class VeggieFeastPizza implements BasePizza
{
    @Override 
    public String getDescription()
    {
        return "Veggie Feast Pizza";
    }

    @Override 
    public double getCost()
    {
        return 199.99;
    } 
}