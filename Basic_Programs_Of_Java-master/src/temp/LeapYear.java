package temp;

public class LeapYear {
    public static void main(String[] args) {
        int leapYear = 2024;
        boolean isLeapYear = (leapYear % 4 == 0 && leapYear % 100 != 0) || (leapYear % 400 == 0);
        System.out.println(leapYear + " isLeapYear " + isLeapYear);
    }
}
