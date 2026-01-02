
package VehicleRental;

public abstract class Vehicle implements Rentable {
    protected double baseRate;

    public Vehicle(double baseRate) {
        this.baseRate = baseRate;
    }
}
