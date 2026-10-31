package com.example.demo.designPattern.factoryDesignPattern.factoryMethod;

public class Square implements Shape {
    @Override 
    public void computeArea()
    {
      
        System.out.println("Inside Square:: compuuteArea() method.");
    }

    @Override
    public void draw()
    {
        System.out.println("Inside Square::draw() method.");
    }
}
