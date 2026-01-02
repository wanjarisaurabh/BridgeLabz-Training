
package VehicleRental;

public class VehicleRentalApp {
    public static void main(String[] args) {

        Vehicle car = new Car();
        Vehicle bike = new Bike();

        System.out.println("Car Rent (3 days): " + car.calculateRent(3));
        System.out.println("Bike Rent (3 days): " + bike.calculateRent(3));
    }
}
