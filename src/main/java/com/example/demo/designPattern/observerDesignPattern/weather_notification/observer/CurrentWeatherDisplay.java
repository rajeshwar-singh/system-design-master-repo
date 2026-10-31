package com.example.demo.designPattern.observerDesignPattern.weather_notification.observer;

import com.example.demo.designPattern.observerDesignPattern.weather_notification.observable.WeatherObservable;

public class CurrentWeatherDisplay implements WeatherObserver {

    private final WeatherObservable observable;
    public CurrentWeatherDisplay(WeatherObservable observable)
    {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override 
    public void update()
    {
        System.out.println("Saving weather data... ");
        display();
    }

    private void display()
    {
        System.out.println("Current weather conditions : " +observable.toString());
    }
}
