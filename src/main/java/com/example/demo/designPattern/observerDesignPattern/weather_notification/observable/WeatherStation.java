package com.example.demo.designPattern.observerDesignPattern.weather_notification.observable;
import com.example.demo.designPattern.observerDesignPattern.weather_notification.observer.*;
import java.util.*;
public class WeatherStation implements WeatherObservable {

    private final List<WeatherObserver> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation()
    {
        
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
        System.out.println("[+] Observer added "+observer.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
        System.out.println("[-] Observer remove "+observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObserver() {
        for (WeatherObserver observer : observers) {
            observer.update();
        }
    }

    @Override 
    public void setWeatherReadings(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObserver();
    }

    public float getTemperature()
    {
        return temperature;
    }
    public float getHumidity()
    {
        return humidity;
    }
    public float getPressure()
    {
        return pressure;
    }

    @Override 
    public String toString()
    {
        return "Weather Station {"+
            " temperature : "+temperature +
            " humidity : " + humidity + 
            " pressure : " + pressure +
            "}";
    } 

    
}
