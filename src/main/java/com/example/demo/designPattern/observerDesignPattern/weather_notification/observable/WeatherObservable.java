package com.example.demo.designPattern.observerDesignPattern.weather_notification.observable;
import com.example.demo.designPattern.observerDesignPattern.weather_notification.observer.*;
public interface WeatherObservable {
    void addObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObserver();
    void setWeatherReadings(float temperature, float humidity, float pressure);
}
