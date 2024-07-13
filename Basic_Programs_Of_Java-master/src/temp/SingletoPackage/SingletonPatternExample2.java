package temp.SingletoPackage;


// Enum Singleton
enum Singleton2 {
    INSTANCE;

    // Singleton-specific methods can be added here
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Main class to test the Singleton pattern
public class SingletonPatternExample2 {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton2 singleton2 = Singleton2.INSTANCE;

        // Call the method
        singleton2.showMessage(); // Output: Hello from Singleton!

        // Get the singleton instance again
        Singleton2 singletonn2 = Singleton2.INSTANCE;

        // Check if both references point to the same instance
        System.out.println("Are both instances the same? " + (singleton2 == singletonn2)); // Output: Are both instances the same? true
    }
}

