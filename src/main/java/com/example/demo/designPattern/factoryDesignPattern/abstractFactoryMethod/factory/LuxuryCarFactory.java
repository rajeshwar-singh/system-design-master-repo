package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.*;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.productImpl.Luxury.*;

public class LuxuryCarFactory implements CarFactory {
    private final String brand;

    public LuxuryCarFactory(String brand)
    {
        this.brand = brand;
    }

    @Override 
    public CarInterior createInterior()
    {
        return new LuxuryCarInterior();
    }
    @Override 
    public CarExterior createExterior()
    {
        return new LuxuryCarExterior();
    }
}
