package leetcode;

/**
 *
 * <a href="https://leetcode.com/problems/search-a-2d-matrix">...</a>
 *
 */
public class Search2DArray {

    public boolean searchMatrix(int[][] matrix, int target) {
        int start=0,end = matrix[0].length-1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]<=target && matrix[i][end]>=target){
                boolean targetFound = binarySearch(matrix,target,i);
                if(targetFound){
                    return targetFound;
                }
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix,int target,int row){
        int start=0,end = matrix[0].length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(matrix[row][mid]==target){
                return true;
            }else if (matrix[row][mid]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }

    public boolean searchMatrixV1(int[][] matrix, int target) {
        int row=0, col = matrix[0].length-1;
        while(row<matrix.length && col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]<target){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }

}
