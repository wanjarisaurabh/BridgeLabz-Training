package cabbygoapp;

abstract class Vehicle {

    protected String vehicleNumber;
    protected int capacity;
    protected String type;

    protected double baseFare;
    protected double ratePerKm;

    // Encapsulated sensitive data
    private double fare;

    public Vehicle(String vehicleNumber, int capacity, String type,
            double baseFare, double ratePerKm) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.baseFare = baseFare;
        this.ratePerKm = ratePerKm;
    }

    // Polymorphic method
    public double calculateFare(double distance) {
        fare = baseFare + distance * ratePerKm;
        return fare;
    }

    public double getFare() {
        return fare;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Capacity: " + capacity);
    }
}
