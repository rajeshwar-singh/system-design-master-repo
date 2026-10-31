package com.example.demo.designPattern.observerDesignPattern.notification_system;

import com.example.demo.designPattern.observerDesignPattern.notification_system.observable.IphoneObservable;
import com.example.demo.designPattern.observerDesignPattern.notification_system.observable.Observable;
import com.example.demo.designPattern.observerDesignPattern.notification_system.observer.EmailObserver;
import com.example.demo.designPattern.observerDesignPattern.notification_system.observer.Observer;
import com.example.demo.designPattern.observerDesignPattern.notification_system.observer.PushObserver;

public class NotificationClient {

    public void start()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("###### E-commerce Store - Stock Availability Notification Feature Demo ######");


        Observable iphoneObservable = new IphoneObservable("17", "Iphone 17", 80000, 10);


        //creating observer
        Observer john_push = new PushObserver("john", 1234567890L);
        Observer neha_email = new EmailObserver("neha25","neha25@gmail.com");
        Observer danish_push = new PushObserver("danish1344", 72782783L);
        Observer satvik_email = new EmailObserver("satvik5","satvik198@gmail.com");



        // Black Friday Sale - Purchase all 10 units
        iphoneObservable.purchase(10);

         // Stock unavailability leads to users subscribing for notifications
         boolean success = iphoneObservable.purchase(1); // Failed purchase

         if(!success)
         {
            iphoneObservable.addObserver(john_push);
            iphoneObservable.addObserver(neha_email);
            iphoneObservable.addObserver(danish_push);
            iphoneObservable.addObserver(satvik_email);


         }

         // Restock 20 units of iPhone 15
         iphoneObservable.restock(20); // All 4 observers are notified

         // Users purchase upon receiving notifications
        iphoneObservable.purchase(1); // John purchases 1 unit
        iphoneObservable.purchase(1); // Katy purchases 1 unit

        // John & Katy unsubscribe from notifications
        iphoneObservable.removeObserver(john_push);
        iphoneObservable.removeObserver(danish_push);

        // NYE Sale - All 18 units sold
        iphoneObservable.purchase(18);
        iphoneObservable.restock(5); // Only Jane & George are notified

        iphoneObservable.purchase(1); // Jane purchases 1 unit
        iphoneObservable.purchase(1); // George purchases 1 unit

        // Jane & George unsubscribe from notifications
        iphoneObservable.removeObserver(neha_email);
        iphoneObservable.removeObserver(satvik_email);

    }
    
}
