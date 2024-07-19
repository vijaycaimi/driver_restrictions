package com.carrentalcompney;

public class FirebaseService implements AlertingService {
    @Override
    public void sendAlert(String carId, int speed) {
        // Implement Firebase logic to send alerts
        // Example: FirebaseMessaging.getInstance().send(new Message(carId, "Speed alert: " + speed));
        System.out.println("Alert sent to Firebase for car " + carId + " with speed " + speed);
    }
}

