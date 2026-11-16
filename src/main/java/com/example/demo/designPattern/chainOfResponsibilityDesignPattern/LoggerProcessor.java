      package com.example.demo.designPattern.chainOfResponsibilityDesignPattern;
      
      public abstract class LoggerProcessor{
      
          public static final int DEBUG = 1;
          public static final int INFO = 2;
          public static final int ERROR = 3;
          public static final int FATAL = 4;
     
          int level;
          LoggerProcessor nextLogger;
     
          public void setNextLogger(LoggerProcessor nextLogger)
          {
              this.nextLogger = nextLogger;
          }
     
          public void logMessage(int level, String message)
          {
              if(this.level == level)
              {
                  write(message);
                  return;
              }
     
              //pass to the next handler of the chain if exist
              if(this.nextLogger != null)
              {
                  this.nextLogger.logMessage(level, message);
              }
          }
     
          abstract protected void write(String message);
      }