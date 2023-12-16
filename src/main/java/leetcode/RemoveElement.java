package leetcode;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        // replace with -1, shift left
        // replace with -1, sort
        int length = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                nums[i]=Integer.MAX_VALUE;
                continue;
            }
            length ++;
        }
        Arrays.sort(nums);
        return length;
        
    }

    /**
     * ------------- Incomplete --------- 
     * 
     * @param nums
     * @param val
     * @return
     */
    public static int removeElementApp2(int[] nums, int val) {
        // replace with -1, shift left
        // replace with -1, sort
        // [1,2,3,1,1,4]
        int length = 0;
        int lastIndex = nums.length-1;
        for (int startIndex = 0 ; startIndex < nums.length ; startIndex++){
            if(nums[startIndex]!=val){
                continue;
            }
            while (lastIndex>=0 && nums[lastIndex] == val){
                lastIndex--;
            }
            
            if(lastIndex>=0){
                int temp = nums[lastIndex];
                nums[lastIndex] = nums[startIndex];
                nums[startIndex] = temp;
            }
        }
        
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                length++;
            }
        }
        return  length;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElementApp2(nums,3));
        System.out.println(Arrays.toString(nums));
    }
}
