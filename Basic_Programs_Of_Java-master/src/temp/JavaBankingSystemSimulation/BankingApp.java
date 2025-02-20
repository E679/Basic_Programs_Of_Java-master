package temp.JavaBankingSystemSimulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Bank Account class
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit Money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ ₹" + amount + " deposited successfully. New Balance: ₹" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw Money
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ ₹" + amount + " withdrawn successfully. New Balance: ₹" + balance);
            return true;
        } else {
            System.out.println("❌ Insufficient funds or invalid amount!");
            return false;
        }
    }

    // Transfer Money
    public boolean transfer(BankAccount receiver, double amount) {
        if (this.withdraw(amount)) {
            receiver.deposit(amount);
            System.out.println("✅ Transfer successful! ₹" + amount + " sent to " + receiver.getAccountHolder());
            return true;
        } else {
            System.out.println("❌ Transfer failed! Check balance.");
            return false;
        }
    }
}

// Banking System Class
class BankingSystem {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Create a new account
    public void createAccount() {
        System.out.print("\nEnter Account Number: ");
        String accNumber = scanner.nextLine();
        if (accounts.containsKey(accNumber)) {
            System.out.println("❌ Account already exists!");
            return;
        }

        System.out.print("Enter Account Holder Name: ");
        String accHolder = scanner.nextLine();

        System.out.print("Enter Initial Deposit Amount: ₹");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        if (initialDeposit < 0) {
            System.out.println("❌ Initial deposit cannot be negative!");
            return;
        }

        BankAccount newAccount = new BankAccount(accNumber, accHolder, initialDeposit);
        accounts.put(accNumber, newAccount);
        System.out.println("✅ Account created successfully!");
    }

    // Perform Transactions
    public void performTransaction() {
        System.out.print("\nEnter Account Number: ");
        String accNumber = scanner.nextLine();

        if (!accounts.containsKey(accNumber)) {
            System.out.println("❌ Account not found!");
            return;
        }

        BankAccount account = accounts.get(accNumber);

        while (true) {
            System.out.println("\n💰 Banking Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Money");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("💳 Account Holder: " + account.getAccountHolder());
                    System.out.println("💰 Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.print("Enter recipient's Account Number: ");
                    String recipientAcc = scanner.next();
                    if (!accounts.containsKey(recipientAcc)) {
                        System.out.println("❌ Recipient account not found!");
                        break;
                    }
                    System.out.print("Enter transfer amount: ₹");
                    double transferAmount = scanner.nextDouble();
                    account.transfer(accounts.get(recipientAcc), transferAmount);
                    break;

                case 5:
                    System.out.println("🔒 Logging out...");
                    return;

                default:
                    System.out.println("❌ Invalid option! Try again.");
            }
        }
    }
}

// Main Class
public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();

        while (true) {
            System.out.println("\n🏦 Welcome to Secure Bank!");
            System.out.println("1. Create Account");
            System.out.println("2. Perform Transaction");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    bankingSystem.createAccount();
                    break;
                case 2:
                    bankingSystem.performTransaction();
                    break;
                case 3:
                    System.out.println("👋 Thank you for using Secure Bank!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Invalid option! Try again.");
            }
        }
    }
}

/*
Output:

🏦 Welcome to Secure Bank!
1. Create Account
2. Perform Transaction
3. Exit
Choose an option: 1

Enter Account Number: 12345
Enter Account Holder Name: John Doe
Enter Initial Deposit Amount: ₹5000
✅ Account created successfully!

🏦 Welcome to Secure Bank!
1. Create Account
2. Perform Transaction
3. Exit
Choose an option: 2

Enter Account Number: 12345

💰 Banking Menu:
1. Check Balance
2. Deposit
3. Withdraw
4. Transfer Money
5. Exit
Choose an option: 1

💳 Account Holder: John Doe
💰 Balance: ₹5000

 */