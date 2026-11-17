package com.example.demo.designPattern.chainOfResponsibilityDesignPattern;

public class LoggerClient
{
    public void startLogger()
    {
        System.out.println("### Chain of Responsibility Design Pattern ###");

        //get the logger chain
        LoggerProcessor loggerProcessor = getChainOfLogger();

        System.out.println("Logging message ----- ");
        System.out.println("------- Logging debug message -------");
        loggerProcessor.logMessage(LoggerProcessor.DEBUG, "This is a debug message");
        System.out.println("------- Logging info message -------");
        loggerProcessor.logMessage(LoggerProcessor.INFO,"This is a info mesaage");
        System.out.println("------- Logging error message -------");
        loggerProcessor.logMessage(LoggerProcessor.ERROR,"This is a error message");
        System.out.println("------- Logging fatal message -------");
        loggerProcessor.logMessage(LoggerProcessor.FATAL,"This is a fatal message");


    }

    private static LoggerProcessor getChainOfLogger()
    {
        LoggerProcessor debugLogger = new DebugLogProcessor(LoggerProcessor.DEBUG);
        LoggerProcessor infoLogger = new InfoLogProcessor(LoggerProcessor.INFO);
        LoggerProcessor errorLogger = new ErrorLogProcessor(LoggerProcessor.ERROR);
        LoggerProcessor fatalLogger = new FatalLogProcessor(LoggerProcessor.FATAL);


        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fatalLogger);
        fatalLogger.setNextLogger(null);

        return debugLogger;
    }
}