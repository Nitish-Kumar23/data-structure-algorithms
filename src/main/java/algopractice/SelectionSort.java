package algopractice;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{5,3,17,1,2,10,4})));
    }

    private static int[] selectionSort(int[] arr) {
        for (int i=0;i<arr.length;i++){
            int minIndex = findMininumElementIndex(arr,i);
            int val = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = val;
        }
        return arr;
    }

    private static int findMininumElementIndex(int[] arr, int start) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i=start;i<arr.length;i++){
            if(arr[i]<minValue){
                minValue = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

}
