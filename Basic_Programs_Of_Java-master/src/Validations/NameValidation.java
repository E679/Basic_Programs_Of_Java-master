package Validations;

import java.util.Scanner;
import java.util.function.Predicate;

public class NameValidation {
    public static final Predicate<String> validateName=
            fieldValue->constantUtils.isValidMaxLength(constantUtils.MAX_NAME_LENGTH,fieldValue)
            &&constantUtils.isValidName(fieldValue);

    private static final String NAME = "NAME";
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter your Name:");
        String inputName=scanner.nextLine();
        boolean validatePhoneNumber = constantUtils.validateStringData(inputName,validateName);
        if (validatePhoneNumber==Boolean.TRUE) {
            System.out.println(NAME+" is Valid");
        }else {
            System.out.println(NAME+" is not Valid\nPlease enter a valid mobile number");
        }

    }
}
