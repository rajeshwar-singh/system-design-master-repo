package com.example.demo.designPattern.decoratorDesignPattern.pizza;

public class FarmhousePizza implements BasePizza
{
    @Override 
    public String getDescription()
    {
        return "Farmhouse Pizza";
    }

    @Override 
    public double getCost()
    {
        return 229.99;
    }
}
