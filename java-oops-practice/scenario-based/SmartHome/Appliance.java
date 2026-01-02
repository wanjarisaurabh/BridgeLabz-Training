
package SmartHome;

public abstract class Appliance implements Controllable {
    private boolean status;

    public boolean isOn() {
        return status;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }
}
