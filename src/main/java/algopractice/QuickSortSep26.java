package algopractice;

import java.util.Arrays;

public class QuickSortSep26 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,6,7,2};
        System.out.println(Arrays.toString(quickSort(arr)));
    }

    private static int[] quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    private static void quickSort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }

        int partition = parition(arr,start,end);
        quickSort(arr,start,partition-1);
        quickSort(arr,partition+1,end);
    }

    private static int parition(int[] arr,int start,int end){
        int pivot = arr[start];
        int left =start+1;
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

        int val = arr[right];
        arr[right] =  arr[start];
        arr[start] = val;

        return right;
    }

}
