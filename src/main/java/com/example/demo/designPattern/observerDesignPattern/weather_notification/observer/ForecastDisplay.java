package com.example.demo.designPattern.observerDesignPattern.weather_notification.observer;

import com.example.demo.designPattern.observerDesignPattern.weather_notification.observable.WeatherObservable;

public class ForecastDisplay implements WeatherObserver {
    private final WeatherObservable observable;
    public ForecastDisplay(WeatherObservable observable)
    {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override 
    public void update()
    {
        System.out.println("Saving weather data...");
        display();
    }

    private void display()
    {
        System.out.println("Forecast weather conditions : " +observable.toString());    
    }

    
}
