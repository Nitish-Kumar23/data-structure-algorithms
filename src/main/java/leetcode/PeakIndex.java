package leetcode;

public class PeakIndex {
    public static void main(String[] args) {
        int[] arr = {3,5,3,2,0};
        System.out.println(getPeakIndexMountainArrayV2(arr));
    }

    //https://leetcode.com/problems/peak-index-in-a-mountain-array/submissions/
    private static int getPeakIndexMountainArray(int[] arr) {
        int start = 0,end = arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(mid==0){
                start=mid+1;
                continue;
            }else if(mid== arr.length-1){
                end = mid-1;
                continue;
            }
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                return mid;
            else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
                end = mid-1;
            }
            else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                start=mid+1;
            }
        }
        return -1;
    }

    private static int getPeakIndexMountainArrayV2(int[] arr) {
        int start = 0,end = arr.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                //we are decreasing part of array and answer will be in left side of mid element
                end = mid;
            else {
                //asc part
                start = mid+1;
            }
        }
        //in the end start==end because of two checks above. And both point to peak element
        return start;
    }
}
