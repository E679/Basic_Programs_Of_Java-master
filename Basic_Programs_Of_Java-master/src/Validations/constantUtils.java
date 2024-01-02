package Validations;

import org.junit.platform.commons.util.StringUtils;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class constantUtils {
    public static final int MAX_EMAIL_LENGTH=60;
    public static final int MAX_PHONE_LENGTH=10;
    public static final int MAX_NAME_LENGTH=25;
    public static final String[] NAME_VALIDATION_REGEX={"[a-zA-Z]+[a-zA-Z'\\-\\.\\s]*"};
    public static final String[] EMAIL_ADDRESS_VALIDATION_REGEX={"^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z0-9_\\-]+$", "^([\\.a-zA-Z0-9_\\-])+@([a-zA-Z0-9_\\-])+(([a-zA-Z0-9_\\-])*\\.([a-zA-Z0-9_\\-])+)+$"
    };
    public static final String[] PHONE_VALIDATION_REGEX={"\\d{10}", "^[2-9][0-9][0-9][2-9][0-9]*$", "^(\\d{3})((?!555)\\d{3})(\\d{4})$"};
    public static boolean isValidMaxLength(Integer length,String value){
        return length==null || value.isEmpty()|| value.trim().length()<=length;
    }
    public static boolean isValidEmail(String fieldValue){
        boolean isValid=matchesValidRegex(fieldValue,constantUtils.EMAIL_ADDRESS_VALIDATION_REGEX);
        return isValid
                && fieldValue.charAt(0)!='.'
                && !fieldValue.contains("..")
                && !fieldValue.contains(".@");
    }
    public static boolean isValidPhone(String phoneNumber){
        return matchesValidRegex(phoneNumber,PHONE_VALIDATION_REGEX);
    }

    public static boolean matchesValidRegex(String value, String[] validationRegex) {
        if(StringUtils.isNotBlank(value)){
            String[] arr=validationRegex;
            int len=validationRegex.length;

            for (int i=0;i<len;++i){
                String regex= arr[i];
                Pattern pattern=Pattern.compile(regex);
                Matcher matcher=pattern.matcher(value);

                if (!matcher.matches()){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isTrue(Boolean bool){
        if (bool==null){
            return false;
        }else {
            return bool;
        }
    }
    public static boolean validateStringData(String inputData, Predicate<String>... validateEmailData) {
        if (!(inputData.isEmpty()) && validateEmailData!=null){
            boolean isValidData=true;
            for(Predicate<String> eachValidateEmailData:validateEmailData){
                if (eachValidateEmailData!=null){
                    isValidData= isTrue(eachValidateEmailData.test(inputData)) && isValidData;
                }
            }
            if (!isValidData){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidName(String fieldValue) {
        return matchesValidRegex(fieldValue,NAME_VALIDATION_REGEX);
    }
}
