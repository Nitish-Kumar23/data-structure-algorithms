package leetcode;

class UniquePaths {

    public int uniquePaths(int m, int n) {
        int rowSize = m-1;
        int colSize = n-1;
        int[][] response = new int[m][n];

        return uniquePaths(0,0,response,rowSize,colSize);
    }

    private int uniquePaths(int row,int col,int[][] response,int rowSize,int colSize){
        if(row>rowSize || col>colSize){
            return 0;
        }

        if(row==rowSize && col==colSize){
            response[row][col] = 1;
            return 1;
        }

        if(response[row][col]!=0){
            return response[row][col];
        }

        int downPaths = uniquePaths(row+1,col,response,rowSize,colSize);
        int rightPaths = uniquePaths(row,col+1,response,rowSize,colSize);

        response[row][col] = downPaths + rightPaths;

        return response[row][col];
    }
}