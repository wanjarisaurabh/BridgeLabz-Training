package com.fleetmanager;

public class Vehicle {
    private String vehicleId;
    private int mileage;
    private String depotName;
    
    public Vehicle(String id,int mileage,String depot){
        this.vehicleId=id;
        this.mileage=mileage;
        this.depotName=depot;
    }
    
    public String getVehicleId(){
        return vehicleId;
    }
    
    public int getMileage(){
        return mileage;
    }
    
    public String getDepotName(){
        return depotName;
    }
}
