package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.productImpl.Luxury;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarInterior;

public class LuxuryCarInterior implements CarInterior{

    @Override 
    public void addInteriorComponent(){
        System.out.println("Adding luxurious interior component to luxury car");
    }
    
}
