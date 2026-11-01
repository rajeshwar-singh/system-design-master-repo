package com.example.demo.interviewProblems.carRental.user;

public class User {
    int userId;
    String username;
    String drivingLicenseNo;

    public User(int userId, String username, String drivingLicenseNo)
    {
        this.userId = userId;
        this.username = username;
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(String drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }
}
