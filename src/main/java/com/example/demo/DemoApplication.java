package com.example.demo;

import com.example.demo.interviewProblems.carRental.CarRentalClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.designPattern.decoratorDesignPattern.PizzaShop;
import com.example.demo.designPattern.factoryDesignPattern.abstractFactoryMethod.Client;
import com.example.demo.designPattern.factoryDesignPattern.factoryMethod.factory.FactoryMethodDemo;
import com.example.demo.designPattern.observerDesignPattern.notification_system.NotificationClient;
import com.example.demo.designPattern.observerDesignPattern.weather_notification.WeatherClient;
import com.example.demo.designPattern.strategyDesignPattern.*;
import com.example.demo.interviewProblems.elevatorDesignProblem.ElevatorClient;
import com.example.demo.interviewProblems.parkingLotProblem.ParkingLotClient;

@SpringBootApplication
public class DemoApplication {
  

  public static void main(String[] args) {
    
    /*//Strategy Design Pattern
    PaymentClient paymentClient = new PaymentClient();
    paymentClient.makePayment();


    //Observer Design Pattern
    System.out.println("Started Observer Design Pattern ---");
    System.out.println();
    NotificationClient notificationClient = new NotificationClient();
    notificationClient.start();


    System.out.println();
    System.out.println();
    System.out.println("Observer Design Pattern - weather station");
    System.out.println();
    WeatherClient weatherClient = new WeatherClient();
    weatherClient.start();


    System.out.println();
    System.out.println();

    //Decorator Design Pattern
    PizzaShop pizzaShop = new PizzaShop();
    pizzaShop.start();



    //Factory Method - Design pattern;
    System.out.println("Started Factory Method Design Pattern ---");
    FactoryMethodDemo factoryMethodDemo = new FactoryMethodDemo();
    factoryMethodDemo.start();

    System.out.println();
    System.out.println("-----------------");
    System.out.println();

    //Abstract factory Method - Design Pattern
    System.out.println("Started Abstract Factory Method Design Pattern ---");
    Client client = new Client();
    client.start();



    System.out.println("-----------------");
    System.out.println();
    System.out.println("System Design Interview Problem - ParkingLot Problem");

    ParkingLotClient parkingLotClient = new ParkingLotClient();
    parkingLotClient.startParkingLotClient();


    System.out.println();
    System.out.println();
    System.out.println("-----------------");
    System.out.println();



    System.out.println();
    System.out.println();
    System.out.println();

    System.out.println("-----------------");
    System.out.println("Elevator System Started ---");
    ElevatorClient elevator = new ElevatorClient();
    elevator.startElevator();
      System.out.println();
      System.out.println();
      System.out.println("Elevator System Completed");

      System.out.println("-----------------");*/

      System.out.println();
      System.out.println();
      System.out.println("-----------------");
      System.out.println("Car Rental System Started");

      CarRentalClient carRentalClient = new CarRentalClient();
      try
      {
          carRentalClient.startCarRentalSystem();
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }


      System.out.println();
      System.out.println();
      System.out.println("Car rental System ended");

      System.out.println("-----------------");




  }

}
