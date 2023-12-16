package leetcode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class WordPattern implements Serializable {


    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
    public static boolean wordPattern(String pattern, String s) {
        Map<String,Character> stringVsPatternMap = new HashMap<>();
        Map<Character,String> patternVsStringMap = new HashMap<>();
        String[] input = s.split(" ");
        if(input.length!=pattern.length()){
            return false;
        }

        int idx=0;
        for(int i=0;i<pattern.length();i++){
            if(patternVsStringMap.containsKey(pattern.charAt(i))){
                if(!patternVsStringMap.get(pattern.charAt(i)).equalsIgnoreCase(input[idx++])){
                    return false;
                }
            }else{
                patternVsStringMap.put(pattern.charAt(i),input[idx++]);
            }
        }

        int idx_2=0;
        for(String ipt : input){
            if(stringVsPatternMap.containsKey(ipt)){
                if(!stringVsPatternMap.get(ipt).equals(pattern.charAt(idx_2++))){
                    return false;
                }
            }else{
                stringVsPatternMap.put(ipt,pattern.charAt(idx_2++));
            }
        }

        return true;

    }

}
