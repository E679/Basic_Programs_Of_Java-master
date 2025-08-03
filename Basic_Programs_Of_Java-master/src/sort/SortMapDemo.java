package sort;

import example.Employee;

import java.util.*;
import java.util.Map.Entry;

public class SortMapDemo {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

		System.out.println(employeeMap);

		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

		/*
		 * for (Entry<String, Integer> entry : entries) {
		 * System.out.println(entry.getKey() + "   " + entry.getValue()); }
		 */

		// map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("****************************");
		// map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

		employeeMap.entrySet().stream()
				.sorted(Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed()))
				.forEach(System.out::println);

		sortMapTraditionalWay();
	}

	private static void sortMapTraditionalWay() {

		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("VB.net", 20);
		map.put("Java", 55);
		map.put("Python", 7);
		map.put("C++", 68);
		map.put("Javascript", 26);
		map.put("C", 86);

		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		System.out.println("In Descending Order:");
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println(entry.getValue() + "=" + entry.getKey());
		}

	}
}
