package algopractice;

import java.util.Arrays;

public class DNFAlgorithm {

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,2,0,1,2,1};
        dnfAlgorithm(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void dnfAlgorithm(int[] arr){
        int left=0,mid=0,right = arr.length-1;
        while (mid<=right){
            if(arr[mid]==0){
                int val = arr[mid];
                arr[mid] = arr[left];
                arr[left] = val;
                left++;
                mid++;
            } else if (arr[mid]==1) {
                mid++;
            }else {
                int val = arr[mid];
                arr[mid] = arr[right];
                arr[right] = val;
                right--;
            }
        }

    }

}
