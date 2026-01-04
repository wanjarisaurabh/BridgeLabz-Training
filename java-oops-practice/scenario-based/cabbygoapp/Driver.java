package cabbygoapp;

class Driver {

    private String name;
    private String licenseNumber;
    private double rating;   // Encapsulated

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public void displayDriver() {
        System.out.println("Driver Name: " + name);
        System.out.println("Rating: " + rating);
    }
}
