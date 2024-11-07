package OnlineShoppingSystem;

public class Admin extends User{
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void performPostLoginActions() {
        System.out.println("In Admin class");
        // Add more actions specific to the admin, like managing products, viewing reports, etc.
    }
}
