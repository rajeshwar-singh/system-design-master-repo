package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.productImpl.Economy;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarInterior;

public class EconomyCarInterior implements CarInterior {

    @Override 
    public void addInteriorComponent()
    {
        System.out.println("Adding basic interior component for economy car");
    }
    
}
