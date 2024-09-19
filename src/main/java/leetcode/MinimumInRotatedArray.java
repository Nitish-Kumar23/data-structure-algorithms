package leetcode;

class MinimumInRotatedArray {
    public static int findMin(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int start=0,end=nums.length-1;
        int globalMin = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]<=nums[end]){
                globalMin = Math.min(globalMin,nums[mid]);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return globalMin;
        
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
}