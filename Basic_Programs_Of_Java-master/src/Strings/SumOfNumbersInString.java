package Strings;

public class SumOfNumbersInString {
    public static void main(String[] args) {
        String s="12ab13bc14";
        int sumFromString = getSumFromString(s);
        System.out.println("sum: "+sumFromString);
    }

    private static int getSumFromString(String s){
        String temp="";
        int sum=0;
        for (char c:s.toCharArray()){
            //Check if number then save to temp
            if(Character.isDigit(c)){
                temp+=c;
            } else {
                //check if saved temp is not empty and parse to make sum
                if(!temp.isEmpty()){
                    sum+=Integer.parseInt(temp);
                    temp="";
                }
            }
        }
        //check to parse to sum last digits in string
        if(!temp.isEmpty()){
            sum+=Integer.parseInt(temp);
        }
        return sum;
    }
}
