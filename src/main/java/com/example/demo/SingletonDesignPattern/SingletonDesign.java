package com.example.demo.SingletonDesignPattern;

public class SingletonDesign {

    private static volatile SingletonDesign instance = null;

    private SingletonDesign() {
    }

    public static SingletonDesign getInstance() {

        if (instance == null) {
            synchronized (SingletonDesign.class) {
                if (instance == null) {
                    instance = new SingletonDesign();
                }
            }
        }
        return instance;

    }

}