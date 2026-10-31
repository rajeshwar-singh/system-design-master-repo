package com.example.demo.designPattern.decoratorDesignPattern.toppings;

import com.example.demo.designPattern.decoratorDesignPattern.pizza.BasePizza;

public abstract class ToppingDecorator implements BasePizza
{
    BasePizza basePizza;
    public ToppingDecorator(BasePizza basePizza)
    {
        this.basePizza = basePizza;
    }

}
