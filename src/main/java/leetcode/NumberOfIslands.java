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

    private void dfs(int row,int col,boolean[][] visited,char[][] grid){
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        visited[row][col] = true;
        for (int[] arr : directions){
            int newRow = row + arr[0];
            int newCol = col + arr[1];
            if(isValidForTraversal(visited, grid, newRow, newCol)){
                dfs(newRow,newCol,visited,grid);
            }
        }
    }

    private static boolean isValidForTraversal(boolean[][] visited, char[][] grid, int newRow, int newCol) {
        return newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && !visited[newRow][newCol] && grid[newRow][newCol] == '1';
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