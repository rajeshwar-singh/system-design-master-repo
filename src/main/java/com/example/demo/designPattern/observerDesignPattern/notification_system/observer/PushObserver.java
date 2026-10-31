package com.example.demo.designPattern.observerDesignPattern.notification_system.observer;

public class PushObserver implements Observer {

    private final String userId;
    private final Long deviceToken;

    public PushObserver(String userId, Long deviceToken) {
        this.userId = userId;
        this.deviceToken = deviceToken;
    }

    @Override
    public void update()
    {
        sendPushNotification();
    }

    private void sendPushNotification()
    {
        System.out.println("!! PUSH NOTIFICATION SENT to: " + deviceToken + " - " + "Product is back in stock! Hurry Up!!");

    }

    @Override
    public String getNotificationMethod() {
        return "Push Notification";
    }

    @Override
    public String getUserId() {
        return userId;
    }
    
}
