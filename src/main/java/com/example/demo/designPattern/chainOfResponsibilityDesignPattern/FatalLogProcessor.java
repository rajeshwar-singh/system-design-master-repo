package com.example.demo.designPattern.chainOfResponsibilityDesignPattern;
public class FatalLogProcessor extends LoggerProcessor
{
    public FatalLogProcessor(int level)
    {
        this.level = level;
    }

    @Override
    protected void write(String message)
    {
        System.out.println("FATAL : "+ message);
    }
}