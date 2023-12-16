package leetcode;

import java.io.Serializable;

public class ReverseWords implements Serializable {

    public static String reverseWords(String s) {

        String[] arr = s.trim().split("\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=arr.length-1;i>=0;i--){
            if(i==0) {
                stringBuilder.append(arr[i]);
                break;
            }
            stringBuilder.append(arr[i]).append(" ");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello   world  "));
    }

}
