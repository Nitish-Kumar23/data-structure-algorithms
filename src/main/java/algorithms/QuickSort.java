package algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7,3,9,10,1,3,6,10,11,15};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
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

}
