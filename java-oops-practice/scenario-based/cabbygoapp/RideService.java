package cabbygoapp;

class RideService implements IRideService {

    private Vehicle vehicle;
    private Driver driver;

    public RideService(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    @Override
    public void bookRide(double distance) {
        System.out.println("Ride Booked Successfully!");
        driver.displayDriver();
        vehicle.getVehicleDetails();
        System.out.println("Fare: ₹" + vehicle.calculateFare(distance));
    }

    @Override
    public void endRide() {
        System.out.println("Ride Ended. Thank you for choosing CabbyGo!");
    }
}

