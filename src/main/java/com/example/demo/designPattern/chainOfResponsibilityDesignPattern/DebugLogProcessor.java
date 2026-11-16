package com.example.demo.designPattern.chainOfResponsibilityDesignPattern;

public class DebugLogProcessor extends LoggerProcessor{
    public DebugLogProcessor(int level)
    {
        this.level = level;
    }

    @Override 
    protected void write(String message)
    {
        System.out.println("Debug : "+message);
    }
}