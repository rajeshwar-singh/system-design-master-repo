package com.example.demo.designPattern.factoryDesignPattern.factoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.*;

public class CircleCreator extends ShapeFactory {
    @Override 
    public Shape createShape()
    {
        return new Circle();
    }
}
