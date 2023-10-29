package Leetcode;

public class FirstOcurrence {

    public static int strStr(String haystack, String needle) {
        if(!haystack.contains(needle)){
            return -1;
        }
        return haystack.indexOf(needle,0);
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));
    }

}
