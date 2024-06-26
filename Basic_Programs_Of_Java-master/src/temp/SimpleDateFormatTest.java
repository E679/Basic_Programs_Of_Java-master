package temp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        long firsttime = System.currentTimeMillis();
        System.out.println(firsttime);
        DateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
        String formattedDate = dateFormat.format(new Date());
        System.out.println(formattedDate);
        long lasttime = System.currentTimeMillis();
        System.out.println(lasttime);

    }
}
