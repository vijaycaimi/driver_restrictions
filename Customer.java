package com.carrentalcompney;

public class Customer {
    private String customerId;
    private int maxAllowedSpeed; // Maximum speed allowed for this customer

    // Constructor, getters, setters
    public Customer(String customerId, int maxAllowedSpeed) {
        this.customerId = customerId;
        this.maxAllowedSpeed = maxAllowedSpeed;
    }

    public int getMaxAllowedSpeed() {
        return maxAllowedSpeed;
    }
}

