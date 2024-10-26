package demo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		list1.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.println("print  Even: " + t));

		Predicate<String> testpred=(s)-> {
				return !s.isEmpty();
		};
		boolean teststrig=testpred.test("abcd");
		System.out.println("String is empty "+teststrig);

	}
}
