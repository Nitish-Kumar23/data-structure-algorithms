package leetcode;

import java.util.ArrayList;
import java.util.List;

class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        List<String> list = new ArrayList<>();
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(matrix[i][j]==0){
                    String row = String.valueOf(i);
                    String col = String.valueOf(j);
                    list.add(String.join("_",row,col));
                }
            }
        }

        for(String element : list){
            String[] arr = element.split("_");
            int row = Integer.parseInt(arr[0]);
            int col = Integer.parseInt(arr[1]);

            setRowElementAsZero(matrix,row,colSize);
            setColElementAsZero(matrix,col,rowSize);
        }
    }

    private void setRowElementAsZero(int[][] arr,int row,int colSize){
        for(int i=0;i<colSize;i++){
            arr[row][i] = 0;
        }
    }

    private void setColElementAsZero(int[][] arr,int col,int rowSize){
        for(int i=0;i<rowSize;i++){
            arr[i][col] = 0;
        }
    }

    public void setZeroesV1(int[][] matrix) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        // check presence of zero in first row
        for(int i=0;i<colSize;i++){
            if(matrix[0][i]==0){
                firstRowHasZero = true;
                break;
            }
        }

        // check presence of zero in first column
        for(int i=0;i<rowSize;i++){
            if(matrix[i][0]==0){
                firstColHasZero = true;
                break;
            }
        }

        for(int i=1;i<rowSize;i++){
            for(int j=1;j<colSize;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<rowSize;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<colSize;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=1;i<colSize;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<rowSize;j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(firstRowHasZero){
            for(int i=0;i<colSize;i++){
                matrix[0][i] = 0;
            }
        }

        if(firstColHasZero){
            for(int i=0;i<rowSize;i++){
                matrix[i][0] = 0;
            }
        }


    }
}