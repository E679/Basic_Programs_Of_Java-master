package Validations;

import java.util.Scanner;
import java.util.function.Predicate;

public class emailValidation {

    public static final Predicate<String> validateEmailData = fieldValue -> constantUtils.isValidMaxLength(constantUtils.MAX_EMAIL_LENGTH, fieldValue)
            && constantUtils.isValidEmail(fieldValue);
    private static final String userEmail = "User-Email";

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter your Email:");
        String inputEmail=scanner.nextLine();
        boolean validateEmail = constantUtils.validateStringData(inputEmail,validateEmailData);
        if (validateEmail==Boolean.TRUE) {
            System.out.println(userEmail+" is Valid");
        }else {
            System.out.println(userEmail+" is not Valid\nPlease enter a valid email");
        }
    }

}
