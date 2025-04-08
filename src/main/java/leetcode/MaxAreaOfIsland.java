package leetcode;

class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] || grid[i][j]==0){
                    continue;
                }

                int area = traversal(i,j,grid,visited);
                maxArea = Math.max(maxArea,area);
            }
        }

        return maxArea;
    }

    private int traversal(int row,int col,int[][] grid,boolean[][] visited){
        if(visited[row][col]){
            return 0;
        }

        visited[row][col] = true;
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        int area = 1;
        for(int[] d : directions){
            int newRow = row + d[0];
            int newCol = col + d[1];
            if(performTraversal(newRow,newCol,grid,visited)){
                area = area + traversal(newRow,newCol,grid,visited);
            }
        }

        return area;
    }

    private boolean performTraversal(int row,int col,int[][] grid,boolean[][] visited){
        if(row>=0 && row<grid.length & col>=0 && col<grid[0].length && !visited[row][col] && grid[row][col]==1){
            return true;
        }
        return false;
    }   
}