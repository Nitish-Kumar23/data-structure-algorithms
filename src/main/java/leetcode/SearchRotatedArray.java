package leetcode;

public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] arr = {3,5,1};
        System.out.println(getElementSortedArray(arr,3));
    }

    //https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
    private static int getElementSortedArray(int[] arr, int target) {
        int pivot =  getPivot(arr);
        //if pivot is not found then array is not rotated just apply simple binary search
        if(pivot==-1){
            return binarySearch(arr,target,0,arr.length-1);
        }
        if(arr[pivot]==target){
            return pivot;
        }
        //if pivot found then we have two ascending arrays
        int index = -1;
        if(target>=arr[0]){
            index = binarySearch(arr,target,0,pivot-1);
        }
        else if(target<arr[0]){
            index = binarySearch(arr,target,pivot+1,arr.length-1);
        }
        return index;
    }

    public static int binarySearch(int[] arr, int targetElement, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            /*
             * int midIndex = (startIndex+endIndex)/2;
             * start+end might have large value which might not fit in integer range
             */
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (arr[midIndex] == targetElement)
                return midIndex;
            boolean isAsc = arr[startIndex] < arr[endIndex];
            if (isAsc) {
                if (arr[midIndex] < targetElement)
                    startIndex = midIndex + 1;
                else if (arr[midIndex] > targetElement)
                    endIndex = midIndex - 1;
            } else {
                if(arr[midIndex]< targetElement)
                    endIndex =midIndex-1;
                else if(arr[midIndex]> targetElement)
                    startIndex =midIndex+1;
            }
        }
        return -1;
    }
    
    public static int getPivot(int[] arr) {
        int start = 0,end = arr.length-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(mid<end && arr[mid]> arr[mid+1]){
                return mid;
            }
            else if(mid>start && arr[mid]< arr[mid-1]){
                return mid-1;
            }
            else if(arr[start]>= arr[mid]){
                end = mid-1;
            }else if(arr[start]< arr[mid]){
                start = mid+1;
            }
        }
        return -1;
    }
}
