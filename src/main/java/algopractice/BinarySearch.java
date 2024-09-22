package algopractice;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,3,5,9,11,17},-3));
        System.out.println(binarySearchV1(new int[]{1,3,5,9,11,17},17));
    }

    public static int binarySearch(int[] arr,int target){
        int start=0, end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }

    private static int binarySearchV1(int[] arr,int target){
        return binarySearchV1(arr,target,0,arr.length-1);
    }

    private static int binarySearchV1(int[] arr,int target,int start,int end){
        if (start>end){
            return -1;
        }

        int mid = start + (end-start)/2;

        if(arr[mid]==target){
            return mid;
        } else if (arr[mid]<target) {
            return binarySearchV1(arr,target,mid+1,end);
        }else {
            return binarySearchV1(arr,target,start,mid-1);
        }
    }

}
