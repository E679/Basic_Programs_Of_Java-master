package DesignPatterns;

/*
The Factory Pattern is a creational design pattern used to create objects without specifying the exact class of object that will be created.
This pattern defines an interface for creating an object, but allows subclasses to alter the type of objects that will be created.

Key Concepts
Encapsulation of Object Creation: The Factory Pattern centralizes object creation, making it easier to manage and change the object creation process.
Decoupling: It decouples the client code from the specific classes that implement the objects, allowing for easier modifications and testing.
Types of Factory Patterns
Simple Factory: A single factory class that creates different types of objects based on input parameters.
Factory Method: A method in a superclass that can be overridden by subclasses to create objects.
Abstract Factory: An interface or abstract class that creates families of related or dependent objects without specifying their concrete classes.
Example: Factory Method Pattern
Here’s a simple implementation of the Factory Method pattern in Java:
 */

//Step 1: Create a Product Interface

interface Animal {
    void speak();
}

//Step 2: Create Concrete Products

class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

//Step 3: Create the Factory

abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

//Step 4: Use the Factory

public class FactoryDesignPattern {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.speak(); // Output: Woof!

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.speak(); // Output: Meow!
    }
}

/*
Explanation
Product Interface (Animal): Defines the common interface for all products (e.g., speak method).
Concrete Products (Dog, Cat): Implement the Animal interface with specific behaviors.
Factory Classes: Abstract factory (AnimalFactory) defines a method for creating products, while concrete factories (DogFactory, CatFactory) implement this method to instantiate specific products.
Client Code: Uses the factory to create objects without needing to know their concrete classes.
Advantages of the Factory Pattern
Flexibility: New types of products can be added with minimal changes to existing code.
Single Responsibility Principle: The factory handles the creation logic, keeping it separate from the business logic.
Ease of Maintenance: Changes in the instantiation of products can be made in the factory classes without affecting client code.
Conclusion
The Factory Pattern is a powerful tool in Java for managing object creation, especially in systems that require scalability and maintainability. It allows you to write more flexible and reusable code by decoupling the creation of objects from their usage
*/
