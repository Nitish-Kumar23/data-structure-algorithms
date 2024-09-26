package algopractice;

import java.util.Arrays;

public class SelectionSortSep26 {

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,6,7,2};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }

    private static int[] selectionSort(int[] arr){
        for (int i=0;i<arr.length;i++){
            int minIndex = minimumIndex(arr,i);
            int val = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = val;

        }
        return arr;
    }

    private static int minimumIndex(int[] arr,int startIndex){
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for (int i=startIndex;i<arr.length;i++){
            if(arr[i]<minValue){
                minIndex = i;
                minValue = arr[i];
            }
        }

        return minIndex;
    }

}
