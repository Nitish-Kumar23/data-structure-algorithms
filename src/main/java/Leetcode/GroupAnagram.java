package Leetcode;

import java.io.Serializable;
import java.util.*;

public class GroupAnagram implements Serializable {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> output = new ArrayList<>();
        Map<String, List<String>> strVsSetMap = new HashMap<>();
        for(String str : strs){
            if(!strVsSetMap.containsKey(str)){
                validAnagramInMap(str,strVsSetMap);
            }else {
                List<String> stringSet = strVsSetMap.get(str);
                stringSet.add(str);
                strVsSetMap.put(str, stringSet);
            }

        }

        for (Map.Entry<String,List<String>> map : strVsSetMap.entrySet()){
            output.add(map.getValue().stream().toList());
        }

        return output;
    }

    public static void validAnagramInMap(String str,Map<String,List<String>> strVsSetMap){
        for(Map.Entry<String,List<String>> map : strVsSetMap.entrySet()){
            boolean validAnagram =  isValidAnagram(map.getKey(),str);
            if(validAnagram){
                List<String> stringSet = map.getValue();
                stringSet.add(str);
                strVsSetMap.put(map.getKey(),stringSet);
                return;
            }
        }

        List<String> stringSet = new ArrayList<>();
        stringSet.add(str);
        strVsSetMap.put(str,stringSet);
    }

    public static boolean isValidAnagram(String s1,String s2){
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        if(s1.length()!=s2.length()){
            return false;
        }
        for (int i=0;i<s1.length();i++){
            int idx = s1.charAt(i)-'a';
            arr1[idx] = arr1[idx] + 1;
        }

        for (int i=0;i<s2.length();i++){
            int idx = s2.charAt(i)-'a';
            arr2[idx] = arr2[idx] + 1;
        }

        for (int i=0;i<s1.length();i++){
            if(arr1[s1.charAt(i)-'a']!=arr2[s1.charAt(i)-'a']){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"","b"}));
    }

    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            // sort the string to have same order while checking anagrams
            char[] sortedArr = str.toCharArray();
            Arrays.sort(sortedArr);
            String sortedStr = new String(sortedArr);

            // add values in map
            map.computeIfAbsent(sortedStr,s->new ArrayList<>()).add(str);
        }
        int[] a  = new int[0];
        return new ArrayList<>(map.values());
    }
}
