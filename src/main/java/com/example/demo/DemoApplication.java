package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.SingletonDesignPattern.SingletonDesign;

@SpringBootApplication
public class DemoApplication {

  // @Value("${NAME:World}")
  // String name;

  // @RestController
  // class HelloworldController {
  //   @GetMapping("/")
  //   String hello() {
  //     return "Hello " + name + "!";
  //   }
  // }

  public static void main(String[] args) {
      //SpringApplication.run(DemoApplication.class, args); 

      Runnable task = ()->{
        SingletonDesign singletonDesign = SingletonDesign.getInstance();
        System.out.println("Thread Name : " +
          Thread.currentThread().getName() + " and using the object with hashcode : "+ singletonDesign.hashCode());
      };

      
      Thread thread1 = new Thread(task, "Thread 1");
      Thread thread2 = new Thread(task, "Thread 2");
      Thread thread3 = new Thread(task, "Thread 3");
      Thread thread4 = new Thread(task, "Thread 4");
      Thread thread5 = new Thread(task, "Thread 5");
      Thread thread6 = new Thread(task, "Thread 6");
      Thread thread7 = new Thread(task, "Thread 7");




      thread1.start();
      thread2.start();
      thread3.start();
      thread4.start();
      thread5.start();
      thread6.start();
      thread7.start();


      


  }

}
