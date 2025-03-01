package mapVsflatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {

        List<Customer> customers = EkartDataBase.getAll();

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> customer.getEmail()
        //customer -> customer.getEmail()  one to one mapping
        List<String> emails = customers.stream()
                .map(customer -> customer.getEmail())
                .collect(Collectors.toList());
        System.out.println(emails);

//customer -> customer.getPhoneNumbers()  ->> one to many mapping
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<List<String>> phoneNumbers = customers.
                stream().map(customer -> customer.getPhoneNumbers())
                .collect(Collectors.toList());
        System.out.println("phoneNumbers: "+phoneNumbers);

        //List<Customer>  convert List<String> -> Data Transformation
        //mapping : customer -> phone Numbers
        //customer -> customer.getPhoneNumbers()  ->> one to many mapping
        List<String> phones = customers.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        System.out.println("Flatmap : "+phones);

        //FlatMap example
        List<List<String>> list3= Arrays.asList(
                Arrays.asList("apple","banana","carrot"),
                Arrays.asList("guava","banana","carrot"),
                Arrays.asList("apple","banana","carrot")
        );

        List<String> collect = list3.stream().flatMap(List::stream).distinct().collect(Collectors.toList());
        System.out.println("Flatmap result "+collect);
    }
}
