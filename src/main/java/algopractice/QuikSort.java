package algopractice;

import java.util.Arrays;

public class QuikSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,17,1,2,10,4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr,int start,int end){
        if(start>end){
            return;
        }

        int partition = partition(arr,start,end);
        quickSort(arr,start,partition-1);
        quickSort(arr,partition+1,end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start+1;
        int right = end;
        while (left<right){
            while (left<=end && arr[left]<=pivot){
                left++;
            }
            while (right>=start && arr[right]>pivot){
                right--;
            }

            if(left<right){
                int val = arr[left];
                arr[left] = arr[right];
                arr[right] = val;
            }
        }

        int val = arr[start];
        arr[start] = arr[right];
        arr[right] = val;

        return right;
    }

}
