package leetcode;

public class RemoveDuplicate {
    
    public static int removeDuplicates(int[] nums){
        // [0,0,1,1,1,2,2,3,3,4]
        int index = 1;
        for (int i=1;i<nums.length-1;i++){
            if(nums[i-1]<nums[i]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
}
