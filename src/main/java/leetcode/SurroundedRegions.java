package leetcode;

class SurroundedRegions {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && isEdgePositions(i,j,board)){
                    traverseCells(i,j,board,visited);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private void traverseCells(int row,int col,char[][] board,boolean[][] visited){
        visited[row][col] = true;
        int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        for(int[] d : directions){
            int cr = row + d[0];
            int cc = col + d[1];
            if(performTraversal(cr,cc,board,visited)){
                traverseCells(cr,cc,board,visited);
            }
        }
    }

    private boolean performTraversal(int row,int col,char[][] board,boolean[][] visited){
        if(row>=0 && row<board.length && col>=0 && col<board[0].length && board[row][col]=='O' && !visited[row][col]){
            return true;
        }
        return false;
    }

    private boolean isEdgePositions(int row,int col,char[][] board){
        if(row==0 || row==board.length-1 || col==0 || col==board[0].length-1){
            return true;
        }
        return false;
    }
}