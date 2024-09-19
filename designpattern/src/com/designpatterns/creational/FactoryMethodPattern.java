// FactoryMethodPattern.java
package com.designpatterns.creational;

// Product Interface
interface Vehicle {
    void drive();
}

// Concrete Product 1
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

// Concrete Product 2
class Truck implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a truck.");
    }
}

// Creator (Factory)
class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("truck")) {
            return new Truck();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type.");
        }
    }
}

// Main class to test the Factory Method pattern
public class FactoryMethodPattern {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.createVehicle("car");
        vehicle.drive();

        vehicle = VehicleFactory.createVehicle("truck");
        vehicle.drive();
    }
}
