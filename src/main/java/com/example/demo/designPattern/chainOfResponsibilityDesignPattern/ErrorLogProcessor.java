package com.example.demo.designPattern.chainOfResponsibilityDesignPattern;
public class ErrorLogProcessor extends LoggerProcessor
{
    public ErrorLogProcessor(int level)
    {
        this.level = level;
    }

    @Override 
    protected void write(String message)
    {
        System.out.println("ERROR : "+ message);
    }
}