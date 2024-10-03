package algopractice;

import java.util.Arrays;

public class MergeSortV3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{3,2,5,5,4,1,6,9})));
    }

    private static int[] mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
        return arr;
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

    private static void merge(int[] arr,int start,int mid,int end){
        int[] left = Arrays.copyOfRange(arr,start,mid+1);
        int[] right = Arrays.copyOfRange(arr,mid+1,end+1);
        int l=0,r=0;
        int index = start;
        while (l<left.length && r<right.length){
            if(left[l]<=right[r]){
                arr[index++] = left[l++];
            }else {
                arr[index++] = right[r++];
            }
        }

        while (l<left.length){
            arr[index++] = left[l++];
        }
        while (r<right.length){
            arr[index++] = right[r++];
        }

    }

}
