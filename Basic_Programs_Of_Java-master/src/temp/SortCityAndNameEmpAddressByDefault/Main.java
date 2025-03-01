package temp.SortCityAndNameEmpAddressByDefault;

import java.util.*;

//sort with city then sort by name without using any logic by default sorting should be done by classes itself

class Employee implements Comparable<Employee> {
    int id;
    String name;
    Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public int compareTo(Employee other) {
        int cityCompare = this.address.compareTo(other.address);
        if (cityCompare != 0) {
            return cityCompare; // Sort by city first
        }
        return this.name.compareTo(other.name); // If same city, sort by name
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + address.city;
    }
}

class Address implements Comparable<Address> {
    String street;
    String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public int compareTo(Address other) {
        return this.city.compareTo(other.city); // Sort by city
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", new Address("Street A", "New York")));
        employees.add(new Employee(2, "Alice", new Address("Street B", "Los Angeles")));
        employees.add(new Employee(3, "Bob", new Address("Street C", "New York")));
        employees.add(new Employee(4, "Charlie", new Address("Street D", "Los Angeles")));
        employees.add(new Employee(5, "David", new Address("Street E", "Chicago")));

        Collections.sort(employees); // Sorting using Comparable

        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    /*
    Output:
5 - David - Chicago
2 - Alice - Los Angeles
4 - Charlie - Los Angeles
3 - Bob - New York
1 - John - New York

     */
}

