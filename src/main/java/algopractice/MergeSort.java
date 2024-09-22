package algopractice;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,17,1,2,10,4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int mid = start + (end-start)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(arr,start,mid+1);
        int[] right = Arrays.copyOfRange(arr,mid+1,end+1);
        int l=0,r=0;
        while (l<left.length && r<right.length){
            if(left[l]<=right[r]){
                arr[start++] = left[l++];
            }

            else {
                arr[start++] = right[r++];
            }
        }

        while (l<left.length){
            arr[start++] = left[l++];
        }

        while (r<right.length){
            arr[start++] = right[r++];
        }
    }

}
