package com.example.demo.designPattern.observerDesignPattern.weather_notification;

import com.example.demo.designPattern.observerDesignPattern.weather_notification.observable.WeatherObservable;
import com.example.demo.designPattern.observerDesignPattern.weather_notification.observable.WeatherStation;
import com.example.demo.designPattern.observerDesignPattern.weather_notification.observer.CurrentWeatherDisplay;
import com.example.demo.designPattern.observerDesignPattern.weather_notification.observer.ForecastDisplay;

public class WeatherClient {
    public void start()
    {
        System.out.println("###### Observer Design Pattern ######");

        WeatherObservable observable = new WeatherStation();
        

        //creating display
        CurrentWeatherDisplay currentDisplay = new CurrentWeatherDisplay(observable);
        ForecastDisplay forecastDisplay = new ForecastDisplay(observable);

        System.out.println("===>>> Initial Weather Update");
        observable.setWeatherReadings(0, 0, 0);
        System.out.println("===>>> Second Weather Update");
        observable.setWeatherReadings(10, 10, 10);
        observable.removeObserver(forecastDisplay);

        System.out.println("===>>> Third Weather Update");
        observable.setWeatherReadings(20, 20, 20);



    }
}
