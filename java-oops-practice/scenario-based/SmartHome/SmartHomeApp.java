
package SmartHome;

public class SmartHomeApp {
    public static void main(String[] args) {

        Appliance light = new Light();

        light.turnOn();
        System.out.println("Is Light ON? " + light.isOn());

        light.turnOff();
        System.out.println("Is Light ON? " + light.isOn());
    }
}
