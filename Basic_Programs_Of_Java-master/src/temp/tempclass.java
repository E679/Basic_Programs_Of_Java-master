package temp;

import java.util.Arrays;

public class tempclass {
    public static void main(String[] args) {
        String s="SuprEEth:Goud";

        String s2= s.split(":")[0];
        String s3= s.split(":")[1];

        System.out.println(s2.replace("S","s"));
        System.out.println(s2.replaceAll("E","e"));
        System.out.println("splitted string arr[0] is "+s2);
        System.out.println("splitted string arr[1] is "+s3);
    }
}
