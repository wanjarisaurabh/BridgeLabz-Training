
package VehicleRental;

public class Bike extends Vehicle {

    public Bike() {
        super(500);
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days;
    }
}
