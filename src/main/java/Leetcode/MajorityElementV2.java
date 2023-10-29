package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementV2 {
    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
        System.out.println(getMajorityElement(arr));
    }

    //https://leetcode.com/problems/majority-element/
    private static Integer getMajorityElement(int[] arr) {
        int count = arr.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer element : arr){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
                if(map.get(element)+1>count){
                    return element;
                }
            }else {
                map.put(element,1);
            }
        }
        for(Map.Entry<Integer,Integer> response : map.entrySet()){
            if(response.getValue()>count){
                return response.getKey();
            }
        }
        return -1;
    }
}
