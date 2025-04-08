package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class MatrixNearestZero {
    public static int[][] updateMatrix(int[][] mat) {
        int[][] response = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    continue;
                }
                boolean[][] visited = new boolean[mat.length][mat[0].length];
                int distance = bfs(i,j,mat,visited);
                response[i][j] = distance;
            }
        }

        return response;
    }

    private static int bfs(int row,int col,int[][] mat,boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        visited[row][col] = true;
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int count = 0;
        while(!queue.isEmpty()){
            count++;

            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] arr = queue.poll();
                for (int[] d : directions) {
                    int newRow = arr[0] + d[0];
                    int newCol = arr[1] + d[1];
                    if (!validboundaries(newRow, newCol, mat)) {
                        continue;
                    }

                    if (mat[newRow][newCol] == 0) {
                        return count;
                    }

                    if (performTraversal(newRow, newCol, mat, visited)) {
                        queue.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }

        return count;
    }

    private static boolean performTraversal(int row,int col,int[][] mat,boolean[][] visited){
        if(validboundaries(row,col,mat) && !visited[row][col] && mat[row][col]!=0){
            return true;
        }
        return false;
    }

    private static boolean validboundaries(int row,int col,int[][] mat){
        return row>=0 && row<mat.length && col>=0 && col<mat[0].length;
    }

    public static void main(String[] args) {
        int[][] response = updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
        for(int[] arr : response){
            System.out.println(Arrays.toString(arr));
        }
    }
}