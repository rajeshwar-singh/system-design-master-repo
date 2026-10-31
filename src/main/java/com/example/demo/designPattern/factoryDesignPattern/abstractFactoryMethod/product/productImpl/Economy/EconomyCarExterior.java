package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.productImpl.Economy;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarExterior;

public class EconomyCarExterior implements CarExterior{
    
    @Override 
    public void addExteriorComponent()
    {
        System.out.println("Adding basic exterior component for economy car");
    }
}
