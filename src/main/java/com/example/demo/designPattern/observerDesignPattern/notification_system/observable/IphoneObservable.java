      package com.example.demo.designPattern.observerDesignPattern.notification_system.observable;
      
      import java.util.*;
      
      import com.example.demo.designPattern.observerDesignPattern.notification_system.observer.Observer;
      
      public class IphoneObservable implements Observable{
      
          private final String productId;
          private final String productName;
          private final double price;
          private int stockQuantity;
          private final List<Observer> observers;
      
          public IphoneObservable(String productId, String productName, double price, int stockQuantity)
          {
              this.productId = productId;
              this.productName = productName;
              this.price = price;
              this.stockQuantity = stockQuantity;
              this.observers = new ArrayList<>();
          }
      
          @Override
          public void addObserver(Observer observer)
          {
              observers.add(observer);
              System.out.println("[+]" + observer.getUserId()+ 
              " subscribed for notification on "+ observer.getNotificationMethod());
      
          }
      
          @Override 
          public void removeObserver(Observer observer)
          {
              observers.remove(observer);
              System.out.println("[-] "+ observer.getUserId() +
               " unsubscribed for the notification on " + observer.getNotificationMethod());
      
          }
      
          @Override 
          public void notifyObserver()
          {
              if(stockQuantity >0 && !observers.isEmpty())
              {
                  System.out.println("Notifying " + observers.size() + " subscribers");
      
      
                  //creating copy to avoid concurrent modification
                  List<Observer> observersNotify = new ArrayList<>(observers);
                  for(Observer observerElement : observersNotify)
                  {
                      observerElement.update();
                  }
              }
          }
      
          // Method to purchase items
          @Override
          public boolean purchase(int quantity) {
              if (stockQuantity >= quantity) {
                  stockQuantity -= quantity;
                  System.out.println("PURCHASE SUCCESS: " + quantity + " units of " + productName + " | " + "Remaining stock: " + stockQuantity);
                  return true;
              } else {
                  System.out.println("PURCHASE FAILED: " + productName + " is out of stock! | " + "Available Quantity: " + stockQuantity);
                  return false;
              }
          }
      
          // Method to restock items
          @Override
          public void restock(int quantity) {
              boolean wasOutOfStock = (stockQuantity == 0);
              stockQuantity += quantity;
              System.out.println("RESTOCKED: " + productName + " - Added " + quantity + " items " + " | " + "Current stock: " + stockQuantity);
              // Only notify if product was previously out of stock
              if (wasOutOfStock && stockQuantity > 0) {
                  notifyObserver();
              }
          }
      
          // Getters
          public String getProductId() {
              return productId;
          }
      
          public String getProductName() {
              return productName;
          }
      
          public double getPrice() {
              return price;
          }
      
          public int getStockQuantity() {
              return stockQuantity;
          }
      
      
          
      }