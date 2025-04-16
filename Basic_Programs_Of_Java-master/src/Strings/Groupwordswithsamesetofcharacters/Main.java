package Strings.Groupwordswithsamesetofcharacters;

import java.util.*;
import java.util.Map.Entry;
public class Main
{
    static String createKey(String wordInList)
    {
        boolean[] charSet = new boolean[26];
        for(int l=0;l<wordInList.length();l++)
        {
            charSet[wordInList.charAt(l)-'a']=true;
        }
        String key="";
        for(int i=0;i<26;i++)
        {
            if(charSet[i])
            {
                key+=(char)(i+'a');
            }
        }
        return key;
    }
    static void wordsInListWithSameSetOfchar(String wordsInList[])
    {
        int n=wordsInList.length;
        HashMap<String, ArrayList<Integer>> hashTable = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            String key = createKey(wordsInList[i]);
            if(hashTable.containsKey(key))
            {
                ArrayList<Integer> temp = hashTable.get(key);
                temp.add(i);
                hashTable.put(key, temp);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                hashTable.put(key, temp);
            }
        }
        for (Entry<String, ArrayList<Integer>> keys : hashTable.entrySet())
        {
            ArrayList<Integer> indices =keys.getValue();
            for (Integer index:indices)
                System.out.print( wordsInList[index] + ", ");
            System.out.println();
        }
        return;
    }
    public static void main(String[] args) {
        String wordsInList[]={ "may", "goddess", "cat", "act","tab", "student", "odist", "dossed","studio","bat","amy", "yam", "blow", "bowl", "lambs", "balms", "looped", "poodle"};
        wordsInListWithSameSetOfchar(wordsInList);
    }
}
/*


Sample Input
Words[]={ "may", "goddess", "cat", "act","tab", "student", "odist", “dossed", "studio", "bat", "amy",  "yam", "blow", "bowl", "lambs", "balms", "looped", "poodle"}

Sample Output
blow, bowl,
lambs, balms,
studio,
odist,
student,
looped, poodle,
tab, bat,
cat, act,
dossed,
goddess,
may, amy, yam,

Output: of above code

student,
tab, bat,
cat, act,
lambs, balms,
odist,
goddess,
studio,
dossed,
may, amy, yam,
blow, bowl,
looped, poodle,
*/



