package com.carrentalcompney;

import java.util.HashMap;
import java.util.Map;

public class CarRentalCompany {
    private Map<String, Customer> customers;
    private Map<String, Car> rentedCars;

    // Constructor
    public CarRentalCompany() {
        customers = new HashMap<>();
        rentedCars = new HashMap<>();
    }

    // Method to add a customer with max allowed speed
    public void addCustomer(String customerId, int maxAllowedSpeed) {
        customers.put(customerId, new Customer(customerId, maxAllowedSpeed));
    }

    // Method to rent a car to a customer
    public void rentCar(String carId, String customerId, AlertingService alertingService) {
        if (!customers.containsKey(customerId)) {
            System.out.println("Customer " + customerId + " not found.");
            return;
        }
        Customer customer = customers.get(customerId);
        rentedCars.put(carId, new Car(carId, customer, alertingService));
        System.out.println("Car " + carId + " rented to customer " + customerId);
    }

    // Method to update speed of a rented car
    public void updateCarSpeed(String carId, int speed) {
        if (!rentedCars.containsKey(carId)) {
            System.out.println("Car " + carId + " is not currently rented.");
            return;
        }
        Car car = rentedCars.get(carId);
        car.setCurrentSpeed(speed);
    }

    // Main method for testing
    public static void main(String[] args) {
        CarRentalCompany rentalCompany = new CarRentalCompany();

        // Add customers with their max allowed speeds
        rentalCompany.addCustomer("C001", 100); // Example: Customer C001 has max speed of 100 km/h

        // Rent a car to a customer
        AlertingService alertingService = new FirebaseService(); // Using Firebase for alerts
        rentalCompany.rentCar("Car001", "C001", alertingService);

        // Update the speed of the rented car
        rentalCompany.updateCarSpeed("Car001", 105); // Example: Car001 exceeds the speed limit
    }
}
