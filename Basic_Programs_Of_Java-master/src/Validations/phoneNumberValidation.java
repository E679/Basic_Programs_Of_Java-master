package Validations;

import java.util.Scanner;
import java.util.function.Predicate;

public class phoneNumberValidation {
    public static final Predicate<String> validatePhoneData=fieldValue->constantUtils.isValidMaxLength(constantUtils.MAX_PHONE_LENGTH,fieldValue)
                                                            && constantUtils.isValidPhone(fieldValue);
    private static final String PHONE_NUMBER = "Mobile-Number";
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please Enter your Mobile-Number:");
        String inputPhone=scanner.nextLine();
        boolean validatePhoneNumber = constantUtils.validateStringData(inputPhone,validatePhoneData);
        if (validatePhoneNumber==Boolean.TRUE) {
            System.out.println(PHONE_NUMBER+" is Valid");
        }else {
            System.out.println(PHONE_NUMBER+" is not Valid\nPlease enter a valid mobile number");
        }
    }
}
