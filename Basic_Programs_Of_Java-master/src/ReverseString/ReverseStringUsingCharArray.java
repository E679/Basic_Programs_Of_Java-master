package ReverseString;

public class ReverseStringUsingCharArray {
    private void reverseStringUsingCharArray(String str){
        str=str.toUpperCase();
        char[] ch=new char[str.length()];
         for(int i=ch.length-1;i>=0;i--){
          System.out.println(str.charAt(i));
        }
    }

    private void reverseStringUsingStringBuilder(String str){
        str=str.toUpperCase();
        StringBuilder sb=new StringBuilder();
        char[] ch=new char[str.length()];
        for(int j=ch.length-1;j>=0;j--){
            sb.append(str.charAt(j));
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String str="Supreeth";
        String str2="sai";
        ReverseStringUsingCharArray obj=new ReverseStringUsingCharArray();
        obj.reverseStringUsingCharArray(str);
        obj.reverseStringUsingStringBuilder(str2);

    }
}
