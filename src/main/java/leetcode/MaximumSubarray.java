package leetcode;

/**
 *
 * <a href="https://leetcode.com/problems/maximum-subarray/?envType=study-plan-v2&envId=top-interview-150">...</a>
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        Integer globalMax = nums[0];
        Integer currentSum = nums[0];
        for(int i=1;i<nums.length;i++){
            currentSum = Math.max(currentSum + nums[i],nums[i]);
            if(currentSum>globalMax){
                globalMax = currentSum;
            }
        }
        return globalMax;
    }

}
