package leetcode;

public class FindElementMoutainArray {
    public static void main(String[] args) {
        int[] arr = {1,5,2};
        System.out.println(findInMountainArray(arr,2));
    }

    //https://leetcode.com/problems/find-in-mountain-array/
    private static int findInMountainArray(int[] arr, int target) {
        int peakIndex = getPeakIndexMountainArrayV2(arr);
        int index = -1;
        //adding validations to search only in valid array part
        //avoid searching in both halves of array
        if(arr[peakIndex]>target){
             index =  getElementIndex(arr,target,0,peakIndex);
        }
        if(arr[peakIndex]<target || index == -1) {
            index = getElementIndex(arr,target,peakIndex,arr.length-1);
        }
        return index;
    }

    public static int getElementIndex(int[] arr, int targetElement,int startIndex,int endIndex) {
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
