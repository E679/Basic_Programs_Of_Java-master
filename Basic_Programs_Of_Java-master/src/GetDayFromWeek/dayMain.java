package GetDayFromWeek;

import java.time.LocalDate;
import java.util.Scanner;

 class findDay
 {
    public static String getDaymethod(int day,int month,int year)
    {
        //int d=Integer.valueOf(day);
        //int m=Integer.valueOf(month);
        //int y=Integer.valueOf(year);
        LocalDate date=LocalDate.of(year,month,day);
        System.out.println("It's ");
        return date.getDayOfWeek().toString();
    }
 }

 public class dayMain
 {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Day: ");
        int day=sc.nextInt();
        System.out.println("Enter Month: ");
        int month=sc.nextInt();
        System.out.println("Enter Year: ");
        int year= sc.nextInt();
        sc.close();
        String res=findDay.getDaymethod(day,month,year);
        System.out.println(res);
    }
}
