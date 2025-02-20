package DesignPatterns.FactoryPatternUsingShape;
/*
Factory Design Pattern in Java
The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass while allowing subclasses to alter the type of objects that will be created.

When to Use Factory Pattern?
✅ When the object creation logic is complex and should not be exposed to the client.
✅ When you need loose coupling between client code and object creation.
✅ When a common interface or superclass is used but different implementations are required dynamically.

Implementation of Factory Pattern in Java
Let's create a Shape Factory that generates different shapes (Circle, Rectangle, Square) without exposing the object creation logic to the client.
 */

//Step 1: Create an Interface
interface Shape {
    void draw();
}

//Step 2: Implement Concrete Classes

// Concrete class implementing Shape
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Concrete class implementing Shape
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Concrete class implementing Shape
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

//Step 3: Create the Factory Class

// Factory class to create objects based on given input
class ShapeFactory {
    // Method to return an instance of a shape based on input
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}


//Step 4: Use the Factory Pattern in the Main Class
public class FactoryPatternDemo {
    public static void main(String[] args) {
        // Creating an instance of the factory
        ShapeFactory shapeFactory = new ShapeFactory();

        // Creating objects using the factory
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();
    }
}
/*
OUTPUT:
Drawing a Circle
Drawing a Rectangle
Drawing a Square

Advantages of Factory Pattern
✅ Encapsulation of object creation logic
✅ Loose coupling (client code depends on an interface, not concrete classes)
✅ Easy maintenance & scalability (adding new shapes requires minimal changes)
✅ Promotes reusability

Where is Factory Pattern Used in Java?
Calendar.getInstance() → Returns an instance of Calendar
DriverManager.getConnection() → Creates database connections
Spring Framework → BeanFactory and ApplicationContext
 */