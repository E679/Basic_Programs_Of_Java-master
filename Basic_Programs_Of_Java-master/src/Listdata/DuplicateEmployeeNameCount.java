package Listdata;

import java.util.*;
import java.util.stream.Collectors;

/*
    Print duplicate employee name count from employee list
 */
public class DuplicateEmployeeNameCount {
    public static void main(String[] args) {
        List<Employee1> employee1s=new ArrayList<>();
        employee1s.add(new Employee1("E40001","RAM","H.R",36));
        employee1s.add(new Employee1("E40002","ASHOK","MANAGER",28));
        employee1s.add(new Employee1("E40003","RAM","ASST MANAGER",28));
        employee1s.add(new Employee1("E40004","SANTOSH","STORE MANAGER",25));
        employee1s.add(new Employee1("E40005","ASHOK","GENERAL MANAGER",26));


        Map<String, Integer> map=new HashMap<>();
        for (Employee1 e:employee1s){
            if (!map.containsKey(e.getName())){
                map.put(e.getName(),1);
            }else {
                map.put(e.getName(),map.get(e.getName())+1);
            }
        }
        System.out.println(map);

        //Using stream API
        Map<String, Long> result=
        employee1s.stream().collect(Collectors.groupingBy(Employee1::getName,Collectors.counting()));

        System.out.println(result);

    }
}
