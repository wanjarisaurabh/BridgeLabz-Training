package cabbygoapp;

public class CabbyGoApp {

    public static void main(String[] args) {

        Vehicle v1 = new Sedan("MH12AB1234");   // Polymorphism
        Driver d1 = new Driver("Ramesh", "DL456789", 4.7);

        IRideService ride = new RideService(v1, d1);
        ride.bookRide(10);   // distance in km
        ride.endRide();
    }
}

