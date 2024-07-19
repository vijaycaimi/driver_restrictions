package com.carrentalcompney;

public class Car implements SpeedMonitoring {
    private String carId;
    private Customer customer; // Customer renting the car
    private int currentSpeed;
    private AlertingService alertingService;

    // Constructor, getters, setters
    public Car(String carId, Customer customer, AlertingService alertingService) {
        this.carId = carId;
        this.customer = customer;
        this.currentSpeed = 0; // Initial speed
        this.alertingService = alertingService;
    }

    @Override
    public void setCurrentSpeed(int speed) {
        this.currentSpeed = speed;
        checkSpeed();
    }

    private void checkSpeed() {
        if (currentSpeed > customer.getMaxAllowedSpeed()) {
            alertingService.sendAlert(carId, currentSpeed);
            System.out.println("Warning: Exceeded speed limit for car " + carId + ". Alert sent.");
        }
    }
}

