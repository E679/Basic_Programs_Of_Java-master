package OnlineShoppingSystem;

public class Main {
    public static void main(String[] args) {
        User customer=new Customer("Supreeth","a1b2c3");
        User admin=new Admin("sai","5678");

        LoginService loginService=new LoginService();

        System.out.println("Logging in Customer");
        loginService.loginUser(customer,"Supreeth","a1b2c3");
        System.out.println("Logging in Admin");
        loginService.loginUser(admin,"sai","5678");
    }
}
