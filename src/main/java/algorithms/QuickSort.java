package algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,9,10,1,3,6,10,11,15};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

        int[] input = new int[]{7,3,9,10,1,3,6,10,11,15};
        quickSortV1(input);
        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] arr,int start,int end) {

        if(start<end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int index = start + 1;
        int pivot = arr[start];
        for (int i=index;i<=end;i++){
            if(arr[i]<=pivot){
                int val = arr[i];
                arr[i] = arr[index];
                arr[index] = val;
                index++;
            }
        }

        int val = arr[index-1];
        arr[index-1] = arr[start];
        arr[start] = val;

        return index-1;
    }

    private static void quickSortV1(int[] arr) {
        quickSortV1(arr,0,arr.length-1);
    }

    private static void quickSortV1(int[] arr,int start,int end) {
        if(start<end){
            int partition = partitionV1(arr,start,end);
            quickSort(arr,start,partition-1);
            quickSort(arr,partition+1,end);
        }
    }

    private static int partitionV1(int[] arr,int start,int end){
        int pivot = arr[start];
        int left = start+1;
        int right = end;
        while (left<=right){
            while (left<=end && arr[left]<=pivot){
                left++;
            }
            while (right>start && arr[right]>pivot){
                right--;
            }

            if(left<right) {
                int val = arr[left];
                arr[left] = arr[right];
                arr[right] = val;
            }
        }
        int val = arr[right];
        arr[right] = arr[start];
        arr[start] = val;

        return right;
    }

}
