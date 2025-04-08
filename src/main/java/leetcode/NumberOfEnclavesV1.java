package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfEnclavesV1 {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    continue;
                }

                if(!visited[i][j] && edgeCell(i,j,grid)){
                    queue.add(new int[]{i,j});
                }
            }
        }

        traversal(queue,grid,visited);

        return unvisitedLandCells(grid,visited);
    }

    private void traversal(Queue<int[]> queue,int[][] grid,boolean[][] visited){
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            dfs(arr[0],arr[1],grid,visited);
        }
    }

    private void dfs(int row,int col,int[][] grid,boolean[][] visited){
        visited[row][col] = true;
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        for(int[] d : directions){
            int newRow = row + d[0];
            int newCol = col + d[1];
            if(performDFS(newRow,newCol,grid,visited)){
                dfs(newRow,newCol,grid,visited);
            }
        }
    }

    private int unvisitedLandCells(int[][] grid,boolean[][] visited){
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean performDFS(int row,int col,int[][] grid,boolean[][] visited){
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