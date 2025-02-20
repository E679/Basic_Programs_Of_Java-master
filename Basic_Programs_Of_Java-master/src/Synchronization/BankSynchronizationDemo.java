package Synchronization;

/*
Example: Bank Account Withdrawal with Synchronization
Let's simulate multiple users withdrawing money from a shared bank account.
We’ll use synchronized methods to prevent inconsistent balance updates.
 */

//Step 1: Create a Shared Resource (Bank Account)
// BankAccount class with synchronized withdraw method
class BankAccount {
    private int balance;

    // Constructor
    public BankAccount(int balance) {
        this.balance = balance;
    }

    // Synchronized method to ensure thread safety
    public synchronized void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println(name + " tried to withdraw " + amount + " but insufficient funds!");
        }
    }
}

//Step 2: Create Threads for Multiple Users

// User thread class that performs withdrawal
class User extends Thread {
    private BankAccount account;
    private int amount;

    // Constructor
    public User(BankAccount account, String name, int amount) {
        super(name); // Set thread name
        this.account = account;
        this.amount = amount;
    }

    // Run method (thread execution)
    @Override
    public void run() {
        account.withdraw(Thread.currentThread().getName(), amount);
    }
}

//Step 3: Create the Main Class to Test Synchronization
public class BankSynchronizationDemo {
    public static void main(String[] args) {
        // Shared bank account with initial balance
        BankAccount account = new BankAccount(500);

        // Creating multiple threads (Users)
        User user1 = new User(account, "Alice", 300);
        User user2 = new User(account, "Bob", 200);
        User user3 = new User(account, "Charlie", 400); // Will fail due to insufficient funds

        // Start threads
        user1.start();
        user2.start();
        user3.start();
    }

    /*
    Output:
Alice is withdrawing 300
Remaining Balance: 200
Charlie tried to withdraw 400 but insufficient funds!
Bob is withdrawing 200
Remaining Balance: 0


    How Synchronization Works in This Program?
The withdraw method is synchronized, ensuring only one thread accesses it at a time.
Without synchronization, multiple threads might read the balance at the same time, causing inconsistent updates (race conditions).
The synchronized block ensures thread atomicity (one thread at a time executes the method).
     */


    //Alternative: Using Synchronized Block Instead of Method
//    public void withdraw(String name, int amount) {
//        synchronized (this) { // Synchronize only this block
//            if (balance >= amount) {
//                System.out.println(name + " is withdrawing " + amount);
//                balance -= amount;
//                System.out.println("Remaining Balance: " + balance);
//            } else {
//                System.out.println(name + " tried to withdraw " + amount + " but insufficient funds!");
//            }
//        }
//    }
}

