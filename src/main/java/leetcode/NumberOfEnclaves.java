package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int reachableCells = 0;
        int landCells = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    continue;
                }
                if(grid[i][j]==1){
                    landCells++;
                }
                if(!visited[i][j] && edgeCell(i,j,grid)){
                    reachableCells = reachableCells + bfs(i,j,grid,visited);
                }
            }
        }

        return landCells - reachableCells;
    }

    private int bfs(int row,int col,int[][] grid,boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        int rechableCells = 1;
        visited[row][col] = true;
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            for(int[] d : directions){
                int newRow = arr[0] + d[0];
                int newCol = arr[1] + d[1];
                if(performBFS(newRow,newCol,grid,visited)){
                    rechableCells++;
                    queue.add(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        return rechableCells;
    }

    private boolean performBFS(int row,int col,int[][] grid,boolean[][] visited){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length && !visited[row][col] && grid[row][col]==1){
            return true;
        }
        return false;
    }

    private boolean edgeCell(int row,int col,int[][] grid){
        if(row==0 || row==grid.length-1 || col==0 || col==grid[0].length-1){
            return true;
        }
        return false;
    }
}