package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,-2,-3,-4,-5},-8)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] duplicateArr = Arrays.copyOf(nums,nums.length);
        quickSort(duplicateArr,0,duplicateArr.length-1);
        int[] elements =  elementsWithSumTarget(duplicateArr,target);
        int[] response = new int[2];
        boolean firstIndexFound=false,secondIndexFound = false;
        for(int i=0;i<nums.length;i++){
            int element = nums[i];
            if(!firstIndexFound && element==elements[0]){
                response[0] = i;
                firstIndexFound = true;
            }else if(!secondIndexFound && element==elements[1]){
                response[1] = i;
                secondIndexFound = true;
            }

            if(firstIndexFound && secondIndexFound){
                return response;
            }
        }
        return response;

    }

    private static void quickSort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }

        int pivot = partition(arr,start,end);
        quickSort(arr,start,pivot-1);
        quickSort(arr,pivot+1,end);
    }

    private static int partition(int[] arr,int start,int end){
        int partition = arr[start];
        int l=start+1,r=end;
        while(l<r){
            while(l<=end && arr[l]<=partition){
                l++;
            }
            while(r>=start && arr[r]>partition){
                r--;
            }
            if(l<r){
                int val = arr[l];
                arr[l] = arr[r];
                arr[r] = val;
            }

        }

        int val = arr[r];
        arr[r] = arr[start];
        arr[start] = val;

        return r;
    }

    private static int[] elementsWithSumTarget(int[] arr,int target){
        int start=0,end=arr.length-1;
        while(start<=end){
            int sum = arr[start] + arr[end];
            if(sum==target){
                return new int[]{arr[start],arr[end]};
            }else if(sum<target){
                start++;
            }else{
                end--;
            }
        }

        return new int[]{-1,-1};
    }

    public static int[] twoSumV1(int[] arr, int target) {
        Map<Integer,Integer> numToIndex = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int complement = target-arr[i];
            if(numToIndex.containsKey(complement)){
                return new int[]{numToIndex.get(complement),i};
            }
            numToIndex.put(arr[i],i);
        }

        return new int[]{-1,-1};
    }

}
