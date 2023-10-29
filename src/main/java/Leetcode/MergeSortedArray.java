package Leetcode;

import java.util.Arrays;

/**
 * 88. https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    /**
     * Insert elements into first array and then sort
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0; //nums2 array counter
        for (int i=m;i<=nums1.length-1;i++){
            nums1[i]=nums2[j];
            j++;
        }
        Arrays.sort(nums1);
    }

    /**
     * Create new array - two pointers add elements in sorted order
     * 
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] mergeExtraSpace(int[] nums1, int m, int[] nums2, int n) {
       int[] result = new int[m+n];
       int index=0;
       int s1=0,s2=0;
       while (s1<m && s2<n){
           if(nums1[s1]<nums2[s2]){
               result[index++] = nums1[s1++];
           }else {
               result[index++] = nums2[s2++];
           }
       }
       
       while (s1<m){
           result[index++] = nums1[s1++];
       }
        while (s2<n){
            result[index++] = nums2[s2++];
        }
        return result;
    }
    
    public static void mergeWithSwap(int[] nums1,int m,int[] nums2,int n){
        int index = m + n -1;
        int s1 = m-1;
        int s2 = n-1;
        if(n==0){
            return; 
        }
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        // [1,2,3,0,0,0]
        // [2,5,6]
        while (s1>=0 && s2>=0 && index>=0){
            if(nums1[s1]<nums2[s2]){
                nums1[index--] = nums2[s2--];
            }else {
                nums1[index--] = nums1[s1--];
            }
        }
        
        while (index>=0 && s1>=0){
            nums1[index--] = nums1[s1--];
        }

        while (index>=0 && s2>=0){
            nums1[index--] = nums2[s2--];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2,0};
        int[] num2 = new int[]{1};
        
        //approach 1
        mergeWithSwap(num1,1,num2,1);
        System.out.println(Arrays.toString(num1));
        
        // create extra array - approach 2
        int[] num3 = new int[]{1,2,3,0,0,0};
        int[] num4 = new int[]{2,5,6};
        System.out.println(Arrays.toString(mergeExtraSpace(num3,3,num4,3)));
        
        // fill the same array and then sort
        int[] num5 = new int[]{1,2,3,0,0,0};
        int[] num6 = new int[]{2,5,6};
        merge(num5,3,num6,3);
        System.out.println(Arrays.toString(num1));
    }
    
}
