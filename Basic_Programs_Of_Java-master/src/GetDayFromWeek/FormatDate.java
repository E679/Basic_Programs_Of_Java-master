package GetDayFromWeek;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FormatDate {
    public static void main(String[] args) {
        String pattern="DD-MM-YYYY";
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(pattern);

        String date=simpleDateFormat.format(new Date());
        System.out.println(date);
        String str1 = "abcdABCDabcdABCD";
        String str2 = "";
        str1=str1.toLowerCase();

        //str1 = str1.replace("a", "");
        ArrayList<Character> al=new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            for (int j = i + 1; j < str1.length(); j++) {
                if (str1.charAt(i) != (str1.charAt(j))) {
                   al.add(str1.charAt(i));
                   break;
                }
            }
        }
        System.out.println(al); // bcdABCDbcdABCD
    }
}
