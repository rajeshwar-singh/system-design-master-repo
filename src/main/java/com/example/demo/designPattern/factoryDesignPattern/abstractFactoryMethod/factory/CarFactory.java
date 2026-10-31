package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarExterior;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.product.CarInterior;

public interface CarFactory {
    CarInterior createInterior();
    CarExterior createExterior();

    default void produceCompleteVechile()
    {
        System.out.println("Starting complete vehicle production");

        CarInterior carInterior = createInterior();
        CarExterior carExterior = createExterior();

        carInterior.addInteriorComponent();
        carExterior.addExteriorComponent();

        System.out.println("Vehicle production completed!");
    }


}
