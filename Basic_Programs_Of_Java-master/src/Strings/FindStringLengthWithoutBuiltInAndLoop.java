package Strings;

public class FindStringLengthWithoutBuiltInAndLoop {
    public static void main(String[] args) {
        String str = "Supreeth";
        int length = findStringLength(str);
        System.out.println("Length of the string: " + length);
    }

    //Another way
    public static int findStringLength(String str) {
        if(str==null || str.isEmpty()){
            return 0;
        }
        return 1+findStringLength(str.substring(1));
    }
}
