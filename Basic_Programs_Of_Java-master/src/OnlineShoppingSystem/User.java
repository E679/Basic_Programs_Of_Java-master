package OnlineShoppingSystem;

/*
Question:

In an online shopping system, you have various types of users, like customers and admins.
Both users must log in, but they have different actions after login.
How would you implement this? In Java

Sol: To implement an online shopping system with different types of users, like customers and admins,
     where both must log in but have different actions after login,
     we can use an object-oriented approach leveraging inheritance and polymorphism in Java

     1. Define a User Base Class The User class will serve as the base class for both Customer and Admin users.
        It will include a login method that both types of users will share,
        and an abstract method performPostLoginActions, which will vary for each type of user.
     2. Define Customer and Admin Classes Both Customer and Admin will inherit from the User class
        and implement the performPostLoginActions method based on their specific needs.
     3. Implement a Login System We can then have a login method to handle user types, perhaps in a main controller or a login service.

Explanation:
Abstraction: The User class defines a general structure for login and post-login actions.
Inheritance: Customer and Admin inherit from User and add specific post-login actions.
Polymorphism: performPostLoginActions is overridden in Customer and Admin, so each performs its unique action.
This approach keeps the code clean, modular, and allows for easy extension if new user types need to be added in the future.

 */
abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public abstract void performPostLoginActions();
}
