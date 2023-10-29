package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * time - O(n)
     * space - O(n)
     * 
     * @param arr
     * @param count
     * @return
     */
    public static int majorityElement(int[] arr,int count){
        Map<Integer,Integer> elementVsCount = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            int c = elementVsCount.getOrDefault(arr[i],0);
            elementVsCount.put(arr[i],c+1);
        }
        for (int i=0;i<arr.length;i++) {
            if(elementVsCount.get(arr[i])>count){
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * Time - O(nlogn)
     * space - O(1)
     * 
     * @param arr
     * @return
     */
    public static int majorityElement(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        int count = arr.length/2;
        Arrays.sort(arr);
        int occurence = 1;
        for (int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                occurence++;
                if(occurence>count){
                    return arr[i];
                }
            }else {
                occurence = 1;
            }
        }
        return -1;
        
    }

    /**
     * Moore voting algorithm
     * time - O(n)
     * space - O(1)
     * 
     * @param arr
     * @return
     */
    public static int majorityElementV1(int[] arr) {
        int candidate = 0;
        int count = 0;
        for (int i=0;i<arr.length;i++){
            if(count==0){
                candidate = arr[i];
            }
            if (arr[i]==candidate){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElementV1(nums));
        System.out.println(majorityElement(nums,nums.length/2));
        System.out.println(majorityElement(nums));
    }
    
    // 2,2,1,1,1,2,2
}
