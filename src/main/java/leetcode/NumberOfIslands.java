package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islandCount = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] || grid[i][j]=='0'){
                    continue;
                }
                islandCount++;
                traversal(i,j,visited,grid);
            }
        }

        return islandCount;
    }

    private void traversal(int row,int col,boolean[][] visited,char[][] grid){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(row,col));
        visited[row][col] = true;

        while(!queue.isEmpty()){
            List<Integer> list = queue.poll();
            int i = list.get(0);
            int j = list.get(1);

            // left traversal
            if(j-1>=0 && grid[i][j-1]=='1' && !visited[i][j-1]){
                visited[i][j-1] = true;
                queue.add(Arrays.asList(i,j-1));
            }

            // right traversal
            if(j+1<grid[0].length && grid[i][j+1]=='1' && !visited[i][j+1]){
                visited[i][j+1] = true;
                queue.add(Arrays.asList(i,j+1));
            }

            // up traversal
            if(i-1>=0 && grid[i-1][j]=='1' && !visited[i-1][j]){
                visited[i-1][j] = true;
                queue.add(Arrays.asList(i-1,j));
            }

            // down traversal
            if(i+1<grid.length && grid[i+1][j]=='1' && !visited[i+1][j]){
                visited[i+1][j] = true;
                queue.add(Arrays.asList(i+1,j));
            }
        }
    }

    private void traversalV1(int row,int col,boolean[][] visited,char[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];

            // left traversal
            if(j-1>=0 && grid[i][j-1]=='1' && !visited[i][j-1]){
                visited[i][j-1] = true;
                queue.add(new int[]{i,j-1});
            }

            // right traversal
            if(j+1<grid[0].length && grid[i][j+1]=='1' && !visited[i][j+1]){
                visited[i][j+1] = true;
                queue.add(new int[]{i,j+1});
            }

            // up traversal
            if(i-1>=0 && grid[i-1][j]=='1' && !visited[i-1][j]){
                visited[i-1][j] = true;
                queue.add(new int[]{i-1,j});
            }

            // down traversal
            if(i+1<grid.length && grid[i+1][j]=='1' && !visited[i+1][j]){
                visited[i+1][j] = true;
                queue.add(new int[]{i+1,j});
            }
        }
    }
}