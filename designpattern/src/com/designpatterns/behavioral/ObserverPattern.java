// ObserverPattern.java
package com.designpatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(float temperature, float humidity);
}

// Concrete Observer
class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("Phone Display: Temperature - " + temperature + ", Humidity - " + humidity);
    }
}

// Subject
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setWeather(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity);
        }
    }
}

// Main class to test the pattern
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        PhoneDisplay phoneDisplay = new PhoneDisplay();

        // Add observer
        weatherStation.addObserver(phoneDisplay);

        // Change weather and notify observers
        weatherStation.setWeather(25.5f, 60.0f);
    }
}

