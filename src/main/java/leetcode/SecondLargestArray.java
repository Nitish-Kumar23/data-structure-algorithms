package leetcode;

import java.util.Arrays;

public class SecondLargestArray {

    /**
     * Brute force : Sort & then find second largest  by comparing --> O(nlogn) + O(n)
     * Better : First largest element & then compare find second largest ---> O(n) + O(n) = O(2n) ~ O(n)
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{1,2,4,3,9,6,7,4}));
        System.out.println(secondLargestV1(new int[]{1,2,4,3,9,6,7,4}));
        System.out.println(secondLargestV2(new int[]{1,2,4,3,9,6,7,4}));
    }

    /**
     * Brute force : Sort & then find second largest  by comparing --> O(nlogn) + O(n)
     *
     * @param arr
     * @return
     */
    private static int secondLargest(int[] arr) {
        // 1,2,4,3,9,6,7,4
        Arrays.sort(arr);

        // 1,2,3,4,4,6,7,9
        int largest = arr[arr.length-1];
        for (int i=arr.length-2;i>=0;i--){
            if(arr[i]<largest){
                return arr[i];
            }
        }

        return -1;

    }

    /**
     * Better : First largest element & then compare find second largest ---> O(n) + O(n) = O(2n) ~ O(n)
     *
     * @param arr
     * @return
     */
    private static int secondLargestV1(int[] arr) {
        int largestElement = LargestElementArray.largestElement(arr);
        int secondLargest = -1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==largestElement){
                continue;
            }
            if(arr[i]>secondLargest){
                secondLargest = arr[i];
            }

        }
        return secondLargest;


    }

    /**
     * Optimal : Keep two pointers for largest & second largest ---> O(n)
     *
     * @param arr
     * @return
     */
    private static int secondLargestV2(int[] arr) {
        int largest = arr[0];
        int secondLargest = -1;

        for (int i=1;i<arr.length-1;i++){
            if(arr[i]>largest){
                int temp = largest;
                largest = arr[i];
                secondLargest = temp;
                continue;
            }
            if(arr[i]<largest){
                if(arr[i]>secondLargest){
                    secondLargest = arr[i];
                }
            }

        }
        return secondLargest;
    }

}
