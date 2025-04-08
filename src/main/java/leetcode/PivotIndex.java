package leetcode;

class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] + sum;
            sum = nums[i];
        }


        for(int i=0;i<nums.length;i++){
            int left = i-1>=0 ? nums[i-1] : 0;
            int right = nums[nums.length-1]-nums[i];
            if(left==right){
                return i;
            }
        }

        return -1;
    }

    public int pivotIndexV1(int[] nums) {
        int tSum = 0;
        for(int i=0;i<nums.length;i++){
            tSum = nums[i] + tSum;
        }

        int lSum = 0;
        for(int i=0;i<nums.length;i++){
            int rSum = tSum - lSum - nums[i];
            if(lSum==rSum){
                return i;
            }
            lSum = lSum + nums[i];
        }

        return -1;
    }
}