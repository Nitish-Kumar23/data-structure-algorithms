package gfg;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
 *
 */
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];
        int count = 0;
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(visited[i][j] || grid[i][j]=='0'){
                    continue;
                }
                bfs(i,j,visited,grid);
                count++;
            }
        }
        
        return count;
    }
    
    private void bfs(int row,int col,boolean[][] visited,char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        visited[row][col] = true;
        
        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int newRow = arr[0] + i;
                    int newCol = arr[1] + j;
                    if(isValidForTraversal(newRow,newCol,visited,grid)){
                        queue.add(new int[]{newRow,newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
    }
    
    private void dfs(int row,int col,boolean[][] visited,char[][] grid){
        visited[row][col] = true;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int newRow = row + i;
                int newCol = col + j;
                if(isValidForTraversal(newRow,newCol,visited,grid)){
                    dfs(newRow,newCol,visited,grid);
                }
            }
        }
        
    }
    
    private boolean isValidForTraversal(int row,int col,boolean[][] visited,char[][] grid){
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length){
            if(!visited[row][col] && grid[row][col]=='1'){
                return true;
            }
        }
        
        return false;
    }
}