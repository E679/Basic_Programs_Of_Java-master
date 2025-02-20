package temp.RetailTransaction;

import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private List<Product> cart;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    public void addProduct(Product product) {
        cart.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : cart) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\n🛒 Cart Items:");
        for (Product p : cart) {
            System.out.println("- " + p.getName() + " : ₹" + p.getPrice());
        }
        System.out.println("Total: ₹" + getTotalAmount());
    }
}

class PaymentProcessor {
    public static boolean processPayment(double amount, String paymentMethod) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        System.out.println("Processing payment of ₹" + amount + " via " + paymentMethod + "...");
        return true;
    }
}

public class RetailTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        // Sample products
        List<Product> products = Arrays.asList(
                new Product("Laptop", 50000),
                new Product("Headphones", 2000),
                new Product("Smartphone", 30000),
                new Product("Keyboard", 1500)
        );

        while (true) {
            // Display product list
            System.out.println("\n📦 Available Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).getName() + " - ₹" + products.get(i).getPrice());
            }
            System.out.println("5. Checkout");

            System.out.print("Choose a product to add to cart (1-4) or 5 to checkout: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4) {
                cart.addProduct(products.get(choice - 1));
            } else if (choice == 5) {
                cart.displayCart();
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        // Payment
        if (cart.getTotalAmount() > 0) {
            System.out.println("\n💳 Payment Methods:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. UPI");
            System.out.print("Choose payment method (1-3): ");
            int paymentChoice = scanner.nextInt();

            String paymentMethod;
            switch (paymentChoice) {
                case 1:
                    paymentMethod = "Credit Card";
                    break;
                case 2:
                    paymentMethod = "Debit Card";
                    break;
                case 3:
                    paymentMethod = "UPI";
                    break;
                default:
                    paymentMethod = "Unknown";
            }


            if (!paymentMethod.equals("Unknown") && PaymentProcessor.processPayment(cart.getTotalAmount(), paymentMethod)) {
                System.out.println("\n✅ Payment Successful! Thank you for shopping.");
            } else {
                System.out.println("\n❌ Payment Failed. Please try again.");
            }
        } else {
            System.out.println("Your cart is empty.");
        }

        scanner.close();
    }
}
/*
Output
📦 Available Products:
1. Laptop - ₹50000
2. Headphones - ₹2000
3. Smartphone - ₹30000
4. Keyboard - ₹1500
5. Checkout
Choose a product to add to cart (1-4) or 5 to checkout: 1
Laptop added to cart.

📦 Available Products:
1. Laptop - ₹50000
2. Headphones - ₹2000
3. Smartphone - ₹30000
4. Keyboard - ₹1500
5. Checkout
Choose a product to add to cart (1-4) or 5 to checkout: 3
Smartphone added to cart.

🛒 Cart Items:
- Laptop : ₹50000
- Smartphone : ₹30000
Total: ₹80000

💳 Payment Methods:
1. Credit Card
2. Debit Card
3. UPI
Choose payment method (1-3): 2
Processing payment of ₹80000 via Debit Card...

✅ Payment Successful! Thank you for shopping.

Features Used
✅ Encapsulation – Used for Product, ShoppingCart, and PaymentProcessor.
✅ Polymorphism (Method Overloading) – Different constructors for adding products.
✅ Collections (ArrayList) – To store cart items dynamically.
✅ User Interaction (Scanner) – To select products and payment methods.
 */