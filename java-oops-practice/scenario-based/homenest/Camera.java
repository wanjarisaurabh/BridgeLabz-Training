package com.scenariobasedquestion.homenest;

public class Camera extends Device {
    private boolean recording;
    
    public Camera(String deviceId, String owner) {
        super(deviceId, owner);
        this.recording = false;
    }
    
    @Override
    public void turnOn() {
        setStatus("ON");
        addEnergyUsage(0.1); // 0.1 kWh per use
        System.out.println("Camera " + getDeviceId() + " is now ON and monitoring");
    }
    
    @Override
    public void turnOff() {
        setStatus("OFF");
        recording = false;
        System.out.println("Camera " + getDeviceId() + " is now OFF");
    }
    
    @Override
    public void reset() {
        turnOff();
        resetEnergyUsage();
        recording = false;
        System.out.println("Camera " + getDeviceId() + " reset - footage cleared");
    }
    
    public void startRecording() {
        if (getStatus().equals("ON")) {
            recording = true;
            System.out.println("Recording started on camera " + getDeviceId());
        } else {
            System.out.println("Turn on camera first!");
        }
    }
    
    public void stopRecording() {
        recording = false;
        System.out.println("Recording stopped");
    }
}
