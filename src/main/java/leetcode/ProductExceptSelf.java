package leetcode;

import java.util.Arrays;

class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // calculate product to the left of each element
        left[0] = nums[0];
        for(int i=1;i<nums.length;i++){
              left[i] = nums[i]*left[i-1];
        }

        // calculate product to the right of each element
        right[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
              right[i] = nums[i]*right[i+1];
        }

        // calculate final product
        int[] output = new int[nums.length];
        output[0] = right[1];
        output[nums.length-1] = left[nums.length-2];
        for(int i=1;i<nums.length-1;i++){
            output[i] = left[i-1] * right[i+1];
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4,})));
    }
}