package algorithms;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearchArray(new int[]{1,2,3,4,8,9,11},1));
        System.out.println(Arrays.toString(selectionSort(new int[]{11,2,1,5,9,3,8})));
        System.out.println(binarySearchArrayV1(new int[]{1,2,3,4,8,9,11},1));
    }

    private static int[] selectionSort(int[] arr) {
        for (int i=0;i<arr.length;i++){
            int minIndex = findMinimumIndex(arr,i);
            int val = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = val;
        }
        return arr;
    }

    private static int findMinimumIndex(int[] arr, int startIndex) {
        int minValue = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i=startIndex;i<arr.length;i++){
            if(arr[i]<minValue){
                minValue = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int binarySearchArray(int[] arr, int target) {
        int start = 0, end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]<target) {
                start = mid + 1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    private static int binarySearchArrayV1(int[] arr, int target) {
        return binarySearchArrayV1(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchArrayV1(int[] arr, int target,int start,int end) {
        if(start>end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(arr[mid]==target){
            return mid;
        } else if (arr[mid]<target) {
            return binarySearchArrayV1(arr,target,mid+1,end);
        }else {
            return binarySearchArrayV1(arr,target,start,mid-1);
        }
    }

}
