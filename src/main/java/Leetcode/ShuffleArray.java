package Leetcode;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        int[] arr = {2,5,1,3,4,7};
        System.out.println(Arrays.toString(shuffleArray(arr,3)));
    }

    /**https://leetcode.com/problems/shuffle-the-array **/ 
    private static int[] shuffleArray(int[] nums, int n) {
        int[] result = new int [nums.length];
        int i=0,j=n;
        int index=0;
        while(j<nums.length){
            result[index] = nums[i];
            result[index+1] = nums[j];
            i++;
            j++;
            index = index+2;
        }
        return result;
    }
}
