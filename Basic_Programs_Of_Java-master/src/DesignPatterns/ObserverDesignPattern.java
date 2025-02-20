package DesignPatterns;

import java.util.ArrayList;
import java.util.List;

//public class ObserverDesignPattern {
//}
/*
Observer Design Pattern in Java
The Observer Pattern is a behavioral design pattern where an object (called Subject) maintains a list of its dependents (Observers) and notifies them of any state changes. This pattern is useful for implementing event-driven systems, such as GUI event listeners or messaging systems.

Key Components:
Subject: Maintains a list of observers and provides methods to attach, detach, and notify observers.
Observer: Defines an update method that gets called when the subject changes.
        ConcreteSubject: Implements the subject interface and notifies observers upon state change.
ConcreteObserver: Implements the observer interface and updates its state based on subject changes.
Example: Implementing Observer Pattern in Java
Let's create a real-world example where YouTube Channel (Subject) notifies its Subscribers (Observers) whenever a new video is uploaded.

*/

//Step 1: Create Observer Interface
// Observer interface
interface Observer {
    void update(String videoTitle);
}

//Step 2: Create Subject Interface


// Subject interface
interface Subject {
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers(String videoTitle);
}

//Step 3: Implement Concrete Subject (YouTube Channel)

// Concrete Subject (YouTube Channel)
class YouTubeChannel implements Subject {
    private List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers(String videoTitle) {
        for (Observer observer : subscribers) {
            observer.update(videoTitle);
        }
    }

    // Method to upload a new video
    public void uploadVideo(String videoTitle) {
        System.out.println("New video uploaded: " + videoTitle);
        notifyObservers(videoTitle);
    }
}

//Step 4: Implement Concrete Observer (Subscribers)

// Concrete Observer (Subscriber)
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " received notification: New video uploaded - " + videoTitle);
    }
}

//Step 5: Test the Observer Pattern

public class ObserverDesignPattern {
    public static void main(String[] args) {
        YouTubeChannel channel = new YouTubeChannel();

        Observer subscriber1 = new Subscriber("Alice");
        Observer subscriber2 = new Subscriber("Bob");
        Observer subscriber3 = new Subscriber("Charlie");

        channel.subscribe(subscriber1);
        channel.subscribe(subscriber2);
        channel.subscribe(subscriber3);

        // Upload a video
        channel.uploadVideo("Observer Pattern Tutorial");

        // Unsubscribe Bob and upload another video
        channel.unsubscribe(subscriber2);
        channel.uploadVideo("Java Design Patterns");
    }
    /*
Output:
New video uploaded: Observer Pattern Tutorial
Alice received notification: New video uploaded - Observer Pattern Tutorial
Bob received notification: New video uploaded - Observer Pattern Tutorial
Charlie received notification: New video uploaded - Observer Pattern Tutorial
New video uploaded: Java Design Patterns
Alice received notification: New video uploaded - Java Design Patterns
Charlie received notification: New video uploaded - Java Design Patterns
     */
}

//        How does the Observer pattern work, and where would you apply it?
//        Observer Pattern is used when one object (Subject) needs to notify multiple objects (Observers) when a change occurs.
//
//        Example: YouTube channel notifications

interface Observer1 {
    void update(String message);
}

class Subscriber1 implements Observer {
    private String name;

    public Subscriber1(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class YouTubeChannel1 {
    private List<Observer> observers = new ArrayList<>();

    void subscribe(Observer o) {
        observers.add(o);
    }

    void notifyObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }
}
