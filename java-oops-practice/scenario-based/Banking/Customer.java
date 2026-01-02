
package Banking;

// Customer entity representing a bank customer
public class Customer {
    private String name;
    private int customerId;

    public Customer(String name, int customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getCustomerDetails() {
        return "Customer: " + name + ", ID: " + customerId;
    }
}
