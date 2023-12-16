package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 * 
 */
class RemoveElementII {

    public static int removeDuplicates(int[] nums) {
        /**
         Map<int,int> map;

         {0,2 : 1,2 : 2,1 : 3,1}
         index=6
         [0,0,1,1,1,1,2,3,3]
         [0,0,1,1,2,3,3]

         */
        int index = 0;
        Map<Integer, Integer> numVsCount = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (numVsCount.containsKey(number)) {
                if (numVsCount.get(number) >= 2) {
                    continue;
                } else {
                    nums[index++] = nums[i];
                    numVsCount.put(number, numVsCount.get(number) + 1);
                }
            } else {
                nums[index++] = nums[i];
                numVsCount.put(number, 1);
            }
        }
        return index;
    }
    

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        int k = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}