package com.jsondata.carjson;

public class Car {
    private String brand;
    private String model;
    private int price;

    // constructor
    public Car(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // getters & setters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // good string representation
    @Override
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', price=" + price + "}";
    }
}
