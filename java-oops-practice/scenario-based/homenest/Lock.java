package com.scenariobasedquestion.homenest;

public class Lock extends Device {
    private boolean locked;
    
    public Lock(String deviceId, String owner) {
        super(deviceId, owner);
        this.locked = true; // default locked
    }
    
    @Override
    public void turnOn() {
        setStatus("ON");
        locked = false;
        addEnergyUsage(0.01); // very low energy
        System.out.println("Lock " + getDeviceId() + " is UNLOCKED");
    }
    
    @Override
    public void turnOff() {
        setStatus("OFF");
        locked = true;
        System.out.println("Lock " + getDeviceId() + " is LOCKED");
    }
    
    @Override
    public void reset() {
        turnOff(); // lock it
        resetEnergyUsage();
        System.out.println("Lock " + getDeviceId() + " reset - security codes cleared");
    }
    
    public boolean isLocked() {
        return locked;
    }
}
