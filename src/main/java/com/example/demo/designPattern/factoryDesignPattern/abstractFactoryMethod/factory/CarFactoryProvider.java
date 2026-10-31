package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.CarType;

public class CarFactoryProvider {
    
    public CarFactory getFactory(CarType type, String brand)
    {
        switch(type)
        {
            case PREMIUM:
            case LUXURY:
                return new LuxuryCarFactory(brand);
            case ECONOMY:
                return new EconomyCarFactory(brand);
            default:
                throw new IllegalArgumentException("Invalid car type");
        }
    }
}
