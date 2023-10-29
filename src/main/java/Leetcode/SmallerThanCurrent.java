package Leetcode;

import java.util.Arrays;

class SmallerThanCurrent {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        System.out.println(Arrays.toString(smallerNumbersThanCurrentV2(arr)));
    }
    
    /**https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions**/
    
    /**sorting changes the order of input and resultant array**/
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            if(i==0){
                result[i] = 0;
                continue;
            }else if(nums[i]!=nums[i-1]){
                result[i] = i;
            }else if(nums[i]==nums[i-1]) {
                result[i] = result[i - 1];
            }
        }
        return result;
    }

    public static int[] smallerNumbersThanCurrentV2(int[] nums) {
        int[] result= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int count =0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]>nums[j])
                    count++;
            }
            result[i] = count;
        }
        return result;
    }
}