package Strings;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */
public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> arr= Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        System.out.println(groupAnagrams(arr));
        //Another easy way in String array
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsFromStringArray(strs));
        System.out.println(groupAnagramsUsingStreams(strs));
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

    public static List<List<String>> groupAnagramsFromStringArray(String[] strs) {
        if (strs==null || strs.length==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map=new HashMap<>();

        for(String word:strs){
            char[] ch=word.toCharArray();
            Arrays.sort(ch);

            String sorted=String.valueOf(ch);
            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(word);
        }
        System.out.println("map keys and values: "+map);
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagramsUsingStreams(String[] strs){
        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(word->{
                    char[] charArray = word.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                }))
                .values()
                .stream()
                .collect(Collectors.toList());
        /*
        understanding above code

        Map<String, List<String>> grpmap = Arrays.stream(strs)
                .collect(Collectors.groupingBy(word -> {
                    char[] charArray = word.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                }));

        List<List<String>> list = grpmap.values().stream().toList();
        return list;
         */
    }

}
