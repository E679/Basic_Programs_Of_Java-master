package Clientbofa;

//Given an array of emails[i], find the number of unique email addresses based on the following rules
//In tej@email.com, "tej" is the local name and "email" is the domain name
//Any '.' in the local name will be ignored. Any text after '+' in the local name will be ignored. These rules do not apply to domain.
//Example: Input of emails = ["test@email.com" , "t.est+tej@email.com", "t.e.s.t@email.com", "test+email@email.com"] should evaluate to just 1 unique email
import java.util.*;
public class UniqueEmails {
    public static void main(String[] args) {
        String [] emails = new String[] {"test.email+tej@email.com", "test.e.mail+bob@email.com", "test.email+jane@e.mail.com", "testemail@email+test.com", "testemail@email.com"};
        System.out.println("Unique email count: " + uniqueEmailCount(emails)); // Output should be 3
    }
    public static int uniqueEmailCount(String[] emails) {

        //code here
        HashSet<String> hs=new HashSet<>();
        int count = 0;

        for(String i: emails){
            int split_position=i.indexOf("@");
            String local_name=i.substring(0,split_position);
            String domain_name=i.substring(split_position);

            if(local_name.contains("+")){
                int plus_position=local_name.indexOf("+");
                local_name=local_name.substring(0,plus_position);
            }
            local_name=local_name.replaceAll("\\.","");
            String new_name=local_name+domain_name;
            hs.add(new_name);
        }
        count = hs.size();

        return count;

    }
}
