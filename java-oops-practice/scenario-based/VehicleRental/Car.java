
package VehicleRental;

public class Car extends Vehicle {

    public Car() {
        super(1200);
    }

    @Override
    public double calculateRent(int days) {
        return baseRate * days;
    }
}
