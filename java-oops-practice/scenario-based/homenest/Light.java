package com.scenariobasedquestion.homenest;

public class Light extends Device {
    private int brightness;
    
    public Light(String deviceId, String owner) {
        super(deviceId, owner);
        this.brightness = 0;
    }
    
    @Override
    public void turnOn() {
        setStatus("ON");
        brightness = 100;
        addEnergyUsage(0.05); // 0.05 kWh per use
        System.out.println("Light " + getDeviceId() + " is now ON at 100% brightness");
    }
    
    @Override
    public void turnOff() {
        setStatus("OFF");
        brightness = 0;
        System.out.println("Light " + getDeviceId() + " is now OFF");
    }
    
    @Override
    public void reset() {
        turnOff();
        resetEnergyUsage();
        System.out.println("Light " + getDeviceId() + " has been reset");
    }
    
    public void setBrightness(int level) {
        if (getStatus().equals("ON")) {
            this.brightness = level;
            System.out.println("Brightness set to " + level + "%");
        } else {
            System.out.println("Turn on the light first!");
        }
    }
}
