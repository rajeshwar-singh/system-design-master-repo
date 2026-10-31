package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarExterior;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarInterior;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.productImpl.Economy.EconomyCarExterior;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.productImpl.Economy.EconomyCarInterior;

public class EconomyCarFactory implements CarFactory {
    private final String brand;

    public EconomyCarFactory(String brand)
    {
        this.brand = brand;
    }

    @Override
    public CarInterior createInterior()
    {
        return new EconomyCarInterior();
    }
    @Override
    public CarExterior createExterior()
    {
        return new EconomyCarExterior();
    }
    
}
