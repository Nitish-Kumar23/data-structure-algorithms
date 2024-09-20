package algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
    }

    private static void mergeSort(int[] nums,int start,int end){
        if(start<end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] arr,int start,int mid,int end){
        int[] left = Arrays.copyOfRange(arr,start,mid+1);
        int[] right = Arrays.copyOfRange(arr,mid+1,end+1);
        int index = start;
        int l=0,r=0;
        while(l<left.length && r<right.length){
            if(left[l]<=right[r]){
                int val = left[l];
                left[l] = arr[index];
                arr[index] = val;
                l++;
            }else{
                int val = right[r];
                right[r] = arr[index];
                arr[index] = val;
                r++;
            }
            index++;
        }

        while(l<left.length){
            arr[index++] = left[l++];
        }

        while(r<right.length){
            arr[index++] = right[r++];
        }

    }

}
