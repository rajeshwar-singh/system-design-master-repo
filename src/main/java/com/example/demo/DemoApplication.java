package com.example.demo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.designPattern.strategyDesignPattern.*;

@SpringBootApplication
public class DemoApplication {
  

  public static void main(String[] args) {
    
    //Strategy Design Pattern  
    PaymentClient paymentClient = new PaymentClient();
    paymentClient.makePayment();
    
  }

}
