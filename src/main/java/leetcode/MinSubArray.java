package leetcode;

public class MinSubArray {

    public static int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int minLength = Integer.MAX_VALUE;
        int start=0;
        int end = 0;
        while(start<=end && end<nums.length){
            sum = sum + nums[end];
            if(sum<target){
                end++;
                continue;
            }
            minLength = Math.min(minLength, end-start+1);
            while(sum>target){
                sum = sum-nums[start];
                start++;
                if(sum>=target) {
                    minLength = Math.min(minLength, end - start + 1);
                }
            }
            end++;
        }
        return minLength==Integer.MAX_VALUE ? 0 : minLength;

    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11,new int[]{1,2,3,4,5}));
    }

}
