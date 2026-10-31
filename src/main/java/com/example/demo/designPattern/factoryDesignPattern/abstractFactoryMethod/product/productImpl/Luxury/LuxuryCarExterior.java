package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.productImpl.Luxury;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarExterior;
public class LuxuryCarExterior implements CarExterior{
    @Override
    public void addExteriorComponent()
    {
        System.out.println("Adding luxury exterior component for luxury car");
    
    }
}