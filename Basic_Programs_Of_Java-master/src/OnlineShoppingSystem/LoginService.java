package OnlineShoppingSystem;

public class LoginService {
    public void loginUser(User user, String enteredUsername, String enteredPassword){
        if(user.login(enteredUsername,enteredPassword)){
            System.out.println("Login Successful");
            user.performPostLoginActions();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
}
