package Leetcode;

import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args) {
        int[][] matrix= {{2,3,9,17},{7,8,10,19},{11,15,16,25},{18,20,22,29}};
        System.out.println(Arrays.toString(getTargetElementV2(matrix,11)));
    }

    //https://leetcode.com/problems/search-a-2d-matrix/submissions/
    
    //brute force approach O(n^2) solution
    private static int[] getTargetElement(int[][] arr, int target) {
        int[] result = {-1,-1};
        for (int row = 0;row<arr.length;row++){
            for (int col = 0;col<arr[row].length;col++){
                if(arr[row][col]==target) {
                    result[0] = row;
                    result[1] = col; 
                    return result;
                }
            }
        }
        return result;
    }

    //optimized approach as the array is sorted row and column wise 
    //n+n = 2n i.e O(n) time complexity
    private static int[] getTargetElementV2(int[][] matrix, int target) {
        int[] result = {-1,-1};
        int row = 0;
        //this is done for cases number of rows and columns are equal
        int col = matrix[0].length-1;
        while (row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                result[0] = row;
                result[1] = col;
                return result;
            }else if(matrix[row][col]<target){
                row++;
            }else if(matrix[row][col]>target){
                col--;
            }
        }
        return result;
    }

}
