package com.sample.elegante;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PreDestroy
    public void onExit() {
      System.out.println("SHUTDOWN REQUEST RECEIVED");
      try {
        Thread.sleep(5 * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("EXITING GRACEFULLY");
    }
}