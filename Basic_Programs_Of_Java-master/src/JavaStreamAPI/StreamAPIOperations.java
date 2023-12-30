package JavaStreamAPI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class StreamAPIOperations {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                        new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                        new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
                        new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                        new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                        new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                        new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                        new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());

        //Todo
        // 1. Find the list of students whose rank is in between 50 and 100

        List<Student> stRankList = studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100).collect(Collectors.toList());
        //System.out.println(stRankList);

        //Todo
        //2. Find the Students who stays in Karnataka and sort them by their names in asc order
        List<Student> sortstnameasc = studentList.stream().filter(student -> student.getCity().equals("Karnataka")).sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
        //System.out.println(sortstnameasc);

        //Find the Students who stays in Karnataka and sort them by their names in descending order
        List<Student> sortstnamedesc = studentList.stream().filter(student -> student.getCity().equals("Karnataka"))
                                    .sorted(Comparator.comparing(Student::getFirstName,Collections.reverseOrder()))
                                    .collect(Collectors.toList());

        //System.out.println(sortstnamedesc);

        //Todo
        // 3. Find all departments names
        List<String> deptNames = studentList.stream().map(Student::getDept).distinct().collect(Collectors.toList());
        //System.out.println(deptNames);

        //Another Way
        Set<String> deptNamesSet = studentList.stream().map(Student::getDept).collect(Collectors.toSet());
        //System.out.println(deptNamesSet);


        //Todo
        //4.  Find all the contact numbers
        List<String> contactList = studentList.stream().flatMap(student -> student.getContacts().stream()).distinct().collect(Collectors.toList());
        //System.out.println(contactList);
        /*
        NOTE:
        if it is one to one field ---------- one2one-> use map
        if it is one to many field ---------- one2many-> use flatmap
         */


        //Todo
        //5.  Group The Student By Department Names
        Map<String, List<Student>> deptGrpNames = studentList.stream().collect(Collectors.groupingBy(Student::getDept));
        //System.out.println(deptGrpNames);


        //Todo
        //6. Find the department who is having maximum number of students
        Map.Entry<String, Long> maxStDept = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting())).entrySet()
                .stream().max(Map.Entry.comparingByValue()).get();
        //System.out.println(maxStDept);


        //Todo
        //7. Find the average age of male and female students
        Map<String, Double> avgAge = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        //System.out.println(avgAge);


        //Todo
        //8. Find the highest rank in each department
        Map<String, Optional<Student>> stdMap = studentList.stream()
                .collect(Collectors.groupingBy(Student::getDept,
                        Collectors.minBy(Comparator.comparing(Student::getRank))));
         System.out.println(stdMap);



        //Todo
        //9 .Find the student who has second rank
        Student secondRank = studentList.stream()
                .sorted(Comparator.comparing(Student::getRank)).skip(2).findFirst().get();
        //System.out.println(secondRank);

        /*
        Github reference : https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbHNEai1KOXM4MVlreHJzbG1sUThENUlFWXREd3xBQ3Jtc0tsRGtXcUhONGgydmFfTlZMM3dyVWhBa3dyNHJxS2xUTGpRWjJPSjBPUk5ZemptU0hjSE1IU2tKYUpreU9Gb0VNS0ZIdnpoZ3hUWnVZUWtMelpHdGZ4ZXl6S0JQY1g4eExJQ3JieGhCMG9VaGNXMTNxTQ&q=https%3A%2F%2Fgithub.com%2FJava-Techie-jt%2Fjava8%2Ftree%2Fmaster%2Fqa&v=Ul_7T2WJIuQ
         */


    }

}
