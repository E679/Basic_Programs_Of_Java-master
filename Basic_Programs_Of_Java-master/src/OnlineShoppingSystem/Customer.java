package OnlineShoppingSystem;

public class Customer extends User{
    public Customer(String username, String password) {
        super(username, password);
    }

    @Override
    public void performPostLoginActions() {
        System.out.println("In Customer class");
        // Add more actions specific to the customer, like viewing products, shopping cart, etc.
    }
}
