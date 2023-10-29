package Leetcode;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        String[] strArray = s.split(" ");
        return strArray[strArray.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World "));
    }
}
