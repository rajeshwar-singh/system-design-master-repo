package com.example.demo.designPattern.factoryDesignPattern.factoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.Shape;
import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.Square;

public class SquareCreator extends ShapeFactory {
    @Override 
    public Shape createShape()
    {
        return new Square();
    }
}
