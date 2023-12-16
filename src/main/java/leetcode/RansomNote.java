package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            }else {
                map.put(magazine.charAt(i),1);
            }
        }
            Map<Character,Integer> hashMap = new HashMap<>();
            for(int i=0;i<ransomNote.length();i++) {
                if (hashMap.containsKey(ransomNote.charAt(i))) {
                    hashMap.put(ransomNote.charAt(i), hashMap.get(ransomNote.charAt(i)) + 1);
                } else {
                    hashMap.put(ransomNote.charAt(i), 1);
                }
            }
        
        
        for (int i=0;i<ransomNote.length();i++){
            if(!map.containsKey(ransomNote.charAt(i))){
                return false;
            }
            if(map.get(ransomNote.charAt(i))<hashMap.get(ransomNote.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public static boolean canConstructV1(String ransomNote,String magazine){
        int[] magazineArray = new int[26];
        for (int i=0;i<magazine.length();i++){
            int s = magazine.charAt(i)-97;
            magazineArray[s] = magazineArray[s] + 1;
        }

        for (int i=0;i<ransomNote.length();i++){
            int s = ransomNote.charAt(i)-97;
            magazineArray[s] = magazineArray[s] - 1;
            if (magazineArray[s]<0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
        System.out.println(canConstructV1("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }

}
