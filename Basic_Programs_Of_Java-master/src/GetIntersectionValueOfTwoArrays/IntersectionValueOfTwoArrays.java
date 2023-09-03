package GetIntersectionValueOfTwoArrays;


import java.util.Arrays;

/*
* Given two integer arrays firstArray and secondArray, return an array of their intersection
* Each element in the result must be unique and you may return the result in any order*/
public class IntersectionValueOfTwoArrays {
    public static void main(String[] args) {
        int firstArray[]={4,9,5};
        int secondArray[]={9,4,9,8,4};

        Arrays.stream(firstArray).filter(x->Arrays.stream(secondArray).anyMatch(y->y==x)).distinct()
                .forEach(System.out::println);

    }
}
