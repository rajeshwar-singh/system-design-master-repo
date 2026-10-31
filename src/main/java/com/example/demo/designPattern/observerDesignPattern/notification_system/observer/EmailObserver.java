package com.example.demo.designPattern.observerDesignPattern.notification_system.observer;

public class EmailObserver implements Observer {
    
    private final String userId;
    private final String emailId;

    public EmailObserver(String userId, String emailId){
        this.userId = userId;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail()
    {
        System.out.println("!! EMAIL SENT to: " + emailId + " - " + "Product is back in stock! Hurry Up!!");
    }

    @Override
    public String getNotificationMethod() {
        return "Email";
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
