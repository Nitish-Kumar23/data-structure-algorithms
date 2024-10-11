package leetcode;

import java.util.* ;
import java.io.*; 
public class CountInversions {

    static long count = 0;

    public static void main(String[] args) {
        System.out.println(getInversions(new long[]{7,5,3,1},4));
    }

    public static long getInversions(long arr[], int n) {
        return getInversions(arr,0,n-1);
    }

    private static long getInversions(long[] arr,int start,int end){
        if(start>=end){
            return 0;
        }

        int mid = start + (end-start)/2;

        getInversions(arr,start,mid);
        getInversions(arr,mid+1,end);

        count = count + merge(arr,start,mid,end);

        return count;

    } 

    private static long merge(long[] arr,int start,int mid,int end){
        long[] left = Arrays.copyOfRange(arr,start,mid+1);
        long[] right = Arrays.copyOfRange(arr,mid+1,end+1);
        int l=0,r=0,sum=0;
        int index = start;
        while(l<left.length && r<right.length){
            if(left[l]<=right[r]){
                arr[index++] = left[l++];
            }else {
                arr[index++] = right[r++];
                sum = sum + (left.length - l);
            }
        }

        while(l<left.length){
            arr[index++] = left[l++];
        }

        while(r<right.length){
            arr[index++] = right[r++];
        }

        return sum;

    }
}