package com.example.demo.designPattern.factoryDesignPattern.factoryMethod.factory;

import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.ShapeType;
import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.Shape;

public class FactoryMethodDemo {

    public void start()
    {

        System.out.println("Factory Method Demo --- ");
        ShapeType shapeType = ShapeType.SQUARE;
        Shape shape = getShapeInstance(shapeType);

        shape.draw();
        shape.computeArea();
    }


    private Shape getShapeInstance(ShapeType shapeType)
    {
        Shape shape = null;
        if(shapeType == null)
        {
            return null;
        }


        switch(shapeType)
        {
            case CIRCLE:
                ShapeFactory circleCreator = new CircleCreator();
                shape = circleCreator.createShape();
                break;
            case RECTANGLE:
                ShapeFactory rectangleCreator =  new RectangleCreator();
                shape = rectangleCreator.createShape();
                break;
            case SQUARE:
                ShapeFactory squareCreator = new SquareCreator();
                shape = squareCreator.createShape();
                break;
            default:
                throw new IllegalStateException("ShapeType doesn't exist.");
        } 
        return shape;  
    }
    
}
