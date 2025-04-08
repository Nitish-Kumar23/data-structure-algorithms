package leetcode;

class NumArray {

    public static void main(String[] args) {
        NumArray ob = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(ob.sumRange(0,2));
        System.out.println(ob.sumRange(2,5));
    }

    private int[] prefixSum;

    public NumArray(int[] nums) {
        this.prefixSum = new int[nums.length];
        int prefix = 0;
        for(int i=0;i<nums.length;i++){
            prefixSum[i] = prefix + nums[i];
            prefix = prefixSum[i];
        }

    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return prefixSum[right];
        }
        return prefixSum[right] - prefixSum[left-1];
    }
}