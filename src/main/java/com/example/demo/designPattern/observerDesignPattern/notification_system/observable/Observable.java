package com.example.demo.designPattern.observerDesignPattern.notification_system.observable;
import  com.example.demo.designPattern.observerDesignPattern.notification_system.observer.*;


public interface Observable {

    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
    boolean purchase(int quantity);
    void restock(int quantity);
    
}
