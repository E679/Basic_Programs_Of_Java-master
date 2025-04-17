package Strings.Groupwordswithsamesetofcharacters;

import java.util.*;
import java.util.Map.Entry;

public class Main1 {

    // Modified createKey method
    static String createKey(String wordInList) {
        Set<Character> charSet = new TreeSet<>();
        for (char c : wordInList.toCharArray()) {
            charSet.add(c);
        }
        StringBuilder key = new StringBuilder();
        for (char c : charSet) {
            key.append(c);
        }
        return key.toString();
    }

    static void wordsInListWithSameSetOfchar(String wordsInList[]) {
        int n = wordsInList.length;
        HashMap<String, ArrayList<Integer>> hashTable = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String key = createKey(wordsInList[i]);
            if (hashTable.containsKey(key)) {
                hashTable.get(key).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                hashTable.put(key, temp);
            }
        }

        for (Entry<String, ArrayList<Integer>> keys : hashTable.entrySet()) {
            ArrayList<Integer> indices = keys.getValue();
            for (Integer index : indices)
                System.out.print(wordsInList[index] + ", ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String wordsInList[] = {
                "may", "goddess", "cat", "act", "tab", "student",
                "odist", "dossed", "studio", "bat", "amy", "yam",
                "blow", "bowl", "lambs", "balms", "looped", "poodle"
        };
        wordsInListWithSameSetOfchar(wordsInList);
    }
}
/*
Output:

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