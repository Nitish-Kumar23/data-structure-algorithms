package algorithms;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortMinimum(new int[]{156,141,35,94,88,61,111})));
        System.out.println(Arrays.toString(sortMaximum(new int[]{156,141,35,94,88,61,111})));
    }

    public static int[] sortMinimum(int[] arr){
        int index = 0;
        for(int i=0;i<arr.length-1;i++){
           int minIndex = smallestElementIndex(arr,index);
           int val = arr[index];
           arr[index] = arr[minIndex];
           arr[minIndex] = val;
           index++;
        }

        return arr;

    }

    public static int[] sortMaximum(int[] arr){
        int index = 0;
        for(int i=0;i<arr.length-1;i++){
            int maxIndex = maximumElementIndex(arr,index);
            int val = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = val;
            index++;
        }

        return arr;

    }

    private static int maximumElementIndex(int[] arr, int startIndex) {
        int maxiumum = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = startIndex;i<arr.length;i++){
            if(arr[i]>maxiumum){
                maxiumum = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int smallestElementIndex(int[] arr, int startIndex) {
        int minimum = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = startIndex;i<arr.length;i++){
            if(arr[i]<minimum){
                minimum = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
