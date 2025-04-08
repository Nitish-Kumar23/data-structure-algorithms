package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int srcValue = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        bfs(sr,sc,image,color,srcValue,visited);
        return image;
    }

    private void bfs(int sr,int sc,int[][] image,int color,int sourceValue,boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;
        int[][] directions = new int[][]{{0,0},{0,-1},{0,1},{-1,0},{1,0}};

        while(!queue.isEmpty()){
            int[] delta = queue.poll();
            for(int[] arr : directions){
                int row = arr[0] + delta[0];
                int col = arr[1] + delta[1];
                if(performTraversal(row,col,visited,sourceValue,image)){
                    visited[row][col] = true;
                    image[row][col] = color;
                    queue.add(new int[]{row,col});
                }
            }
        }
    }

    private void dfs(int sr,int sc,int[][] image,int color,int sourceValue,boolean[][] visited){
        visited[sr][sc] = true;
        image[sr][sc] = color;
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        for(int[] arr : directions){
            int newRow = sr + arr[0];
            int newCol = sc + arr[1];
            if(performTraversal(newRow,newCol,visited,sourceValue,image)){
                dfs(newRow,newCol,image,color,sourceValue,visited);
            }
        }

    }

    private boolean performTraversal(int row,int col,boolean[][] visited,int sourceValue,int[][] image){
        if(row>=0 && row<visited.length && col>=0 && col<visited[0].length && !visited[row][col] && image[row][col]==sourceValue){
            return true;
        }

        return false;
    }
}