package leetcode;

public class LargestElementArray {

    /**
     * 1. Sort & then return arr[n-1] --> O(nlogn)
     * 2. Maintain max largest number till i & then iterate --> O(n)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(largestElement(new int[]{1,2,3,4,5,321,31,410,41}));
    }

    public static int largestElement(int[] arr) {
        int largest = arr[0];
        for (int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }

}
