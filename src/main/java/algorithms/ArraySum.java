package algorithms;

import java.util.Arrays;

/**
 *
 * Array sum using divide and conquer
 *
 */
public class ArraySum {

    public static void main(String[] args) {
        System.out.println(sum(new int[]{2,4,6}));
        System.out.println(sumV1(new int[]{2,4,6}));
        System.out.println(maxElement(new int[]{2,4,6,7,31,4,5}));
        System.out.println(maxElementV1(new int[]{2,4,6,7,31,4,5}));
    }

    private static int sum(int[] arr) {
        if(arr.length==0){
            return 0;
        }

        return arr[0] + sum(Arrays.copyOfRange(arr,1,arr.length));
    }

    private static int sumV1(int[] arr) {
        return sumV1(arr,0);
    }

    private static int sumV1(int[] arr,int index) {
        if(index==arr.length-1){
            return arr[index];
        }

        return arr[index] + sumV1(arr,index+1);
    }

    private static int maxElement(int[] arr){
        if(arr.length==0){
            return -1;
        }

        return Math.max(arr[0],maxElement(Arrays.copyOfRange(arr,1,arr.length)));
    }

    private static int maxElementV1(int[] arr){
        return maxElementV1(arr,0);
    }

    private static int maxElementV1(int[] arr,int index){
        if(index==arr.length-1){
            return arr[index];
        }

        return Math.max(arr[index],maxElementV1(arr,index+1));
    }

}
