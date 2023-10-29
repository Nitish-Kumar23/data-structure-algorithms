package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> valueVsIndex = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if(valueVsIndex.containsKey(nums[i])){
                int diff = i - valueVsIndex.get(nums[i]);
                if(diff<=k){
                    return true;
                }
            }
            valueVsIndex.put(nums[i],i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));
    }

}
