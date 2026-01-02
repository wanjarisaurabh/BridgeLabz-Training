
package SmartHome;

public class Light extends Appliance {

    @Override
    public void turnOn() {
        setStatus(true);
        System.out.println("Light turned ON");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Light turned OFF");
    }
}
