package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> sMap = new LinkedHashMap<>();
        HashMap<Character,Character> tMap = new LinkedHashMap<>();
        String[] arr =  s.split(" ");
        for (int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            if(sMap.containsKey(sChar)){
                if(sMap.get(sChar)!=t.charAt(i)){
                    return false;
                }
            }else {
                sMap.put(sChar,t.charAt(i));
            }
        }

        for (int i=0;i<t.length();i++){
            char tChar = t.charAt(i);
            if(tMap.containsKey(tChar)){
                if(tMap.get(tChar)!=s.charAt(i)){
                    return false;
                }
            }else {
                tMap.put(tChar,s.charAt(i));
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("bbbaaaba","aaabbbba"));
    }
}
