package Leetcode;

import java.io.Serializable;

public class LongestSubstring implements Serializable {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        while(start<=end && end<s.length()){
            char searchChar = s.charAt(end);
            if(!charExists(s.substring(start,end),searchChar)){
                maxLength = Math.max(maxLength,end-start+1);
                end++;
                continue;
            }
            start++;
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }

    private static boolean charExists(String string, char searchChar) {
        for (int i=0;i<string.length();i++){
            if(string.charAt(i)==searchChar){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
