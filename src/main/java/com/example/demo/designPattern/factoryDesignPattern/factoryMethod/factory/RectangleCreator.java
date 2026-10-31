package com.example.demo.designPattern.factoryDesignPattern.factoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.Rectangle;
import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.Shape;

public class RectangleCreator extends ShapeFactory {

    @Override
    public Shape createShape()
    {
        return new Rectangle();
    }
    
}
