package leetcode;

class RotateImage {
    public void rotate(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        for(int i=0;i<rowSize;i++){
            for(int j=i;j<colSize;j++){
                int val = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = val;
            }
        } 

        for(int i=0;i<rowSize;i++){
            int start=0, end = colSize-1;
            while(start<end){
                int val = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = val;
                start++;
                end--;
            }
        }

    }
}