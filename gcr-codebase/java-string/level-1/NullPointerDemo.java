
public class NullPointerDemo {

    // This method generates NullPointerException
    static void createException() {
        String text = null;
        text.length();
    }

    // This method handles NullPointerException
    static void handleException() {
        try {
            String text = null;
            text.charAt(0);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled properly");
        }
    }

    public static void main(String[] args) {
        try {
            createException();
        } catch (Exception e) {
            handleException();
        }
    }
}
