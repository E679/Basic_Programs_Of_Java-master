package temp;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> arr= Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        System.out.println(groupAnagrams(arr));
    }

    private static List<List<String>> groupAnagrams(List<String> arr) {
        if (arr==null || arr.size()==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        for(String word:arr){
            char[] ch=word.toCharArray();
            Arrays.sort(ch);

            String key=String.valueOf(ch);

            if (!map.containsKey(key))
                map.put(key,new ArrayList<>());

            map.get(key).add(word);
        }
        for (Map.Entry<String,List<String>> eachmapword:map.entrySet()){
            result.add(eachmapword.getValue());
        }
        return result;
    }

}
