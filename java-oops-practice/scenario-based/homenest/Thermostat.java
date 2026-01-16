package com.scenariobasedquestion.homenest;

public class Thermostat extends Device {
    private int temperature;
    
    public Thermostat(String deviceId, String owner) {
        super(deviceId, owner);
        this.temperature = 24; // default temp
    }
    
    @Override
    public void turnOn() {
        setStatus("ON");
        addEnergyUsage(0.2); // 0.2 kWh per use
        System.out.println("Thermostat " + getDeviceId() + " is now ON at " + temperature + "°C");
    }
    
    @Override
    public void turnOff() {
        setStatus("OFF");
        System.out.println("Thermostat " + getDeviceId() + " is now OFF");
    }
    
    @Override
    public void reset() {
        turnOff();
        temperature = 24;
        resetEnergyUsage();
        System.out.println("Thermostat " + getDeviceId() + " reset to default settings");
    }
    
    public void setTemperature(int temp) {
        if (getStatus().equals("ON")) {
            this.temperature = temp;
            System.out.println("Temperature set to " + temp + "°C");
        } else {
            System.out.println("Turn on thermostat first!");
        }
    }
}
