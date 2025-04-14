package NeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


// https://neetcode.io/problems/duplicate-integer
class HasDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums){
            if(set.contains(val)){
                return true;
            }
            set.add(val);
        }
        return false;
    }

    public boolean hasDuplicateV1(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return false;
        }
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]){
                return true;
            }
        }

        return false;
    }
}
