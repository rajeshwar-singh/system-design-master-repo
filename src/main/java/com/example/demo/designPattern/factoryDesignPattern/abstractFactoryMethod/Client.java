package com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.factory.CarFactory;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.factory.CarFactoryProvider;

public class Client {

    public void start() {
        System.out.println("Abstract Factory Design Pattern Example");
        System.out.println("-----------------------------------");

        CarFactoryProvider carFactoryProvider = new CarFactoryProvider();

        CarFactory economyCar = carFactoryProvider.getFactory(CarType.ECONOMY, "Maruti");
        CarFactory luxuryCar = carFactoryProvider.getFactory(CarType.LUXURY, "BMW");
        economyCar.produceCompleteVechile();   
        luxuryCar.produceCompleteVechile();

    }

}
