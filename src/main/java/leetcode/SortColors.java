package leetcode;

class SortColors {

    /**
     *
     * Two-pass sorting solution
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
            }else if(nums[i]==1){
                oneCount++;
            }else{
                twoCount++;
            }
        }
        int index = 0;
        while(zeroCount>0){
            nums[index++] = 0;
            zeroCount--;
        }
        while(oneCount>0){
            nums[index++] = 1;
            oneCount--;
        }
        while(twoCount>0){
            nums[index++] = 2;
            twoCount--;
        }

    }

    /**
     *
     * Dutch national flag algorithm (DNF)
     * One pass solution
     *
     * @param arr
     */
    public void sortColorsV1(int[] arr) {
        int left=0,index=0,right=arr.length-1;
        while(index<=right){
            if(arr[index]==0){
                int val = arr[left];
                arr[left] = arr[index];
                arr[index] = val;
                left++;
                index++;
            }else if(arr[index]==1){
                index++;
            }else {
                int val = arr[right];
                arr[right] = arr[index];
                arr[index] = val;
                right--;
            }
        }

    }
}