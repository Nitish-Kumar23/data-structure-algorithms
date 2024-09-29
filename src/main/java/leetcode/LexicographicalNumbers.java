package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class LexicographicalNumbers {

    public static void main(String[] args) {
        System.out.println(lexicalOrder(25));
        System.out.println(lexicalOrderV3(25));
    }
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        lexicalOrder(0,n,list);
        return list;
    }

    private static void lexicalOrder(int currentSum,int n,List<Integer> list){
        if(currentSum>n){
            return;
        }

        for(int i=0;i<10;i++){
            int nextSum = currentSum*10 + i;
            if(nextSum==0){
                continue;
            }
            if(nextSum>n){
                return;
            }
            list.add(nextSum);
            lexicalOrder(nextSum,n,list);
        }
    }

    public List<Integer> lexicalOrderV1(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<10;i++){
            if(i>n){
                break;
            }
            lexicalOrderV1(i,n,list);
        }
        return list;
    }

    private void lexicalOrderV1(int currentSum,int n,List<Integer> list){
        if(currentSum>n){
            return;
        }

        list.add(currentSum);

        for(int i=0;i<10;i++){
            int nextSum = currentSum*10 + i;
            if(nextSum>n){
                break;
            }
            lexicalOrderV1(nextSum,n,list);
        }
    }

    public static List<Integer> lexicalOrderV3(int n) {
        List<String> input = new ArrayList<>();
        for (int i=1;i<=n;i++){
            input.add(String.valueOf(i));
        }
        // inbuilt method for lexicographical sorting of string in java
        Collections.sort(input);
        List<Integer> result = new ArrayList<>();
        for (String element : input){
            result.add(Integer.parseInt(element));
        }
        return result;
    }

}