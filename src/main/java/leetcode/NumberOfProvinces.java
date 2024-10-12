package leetcode;

class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int provinceCount = 0;
        int colSize = isConnected[0].length;
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                provinceCount++;
                dfs(i,visited,isConnected,colSize);
            }
        }

        return provinceCount;
    }

    private void dfs(int vertex,boolean[] visited,int[][] isConnected,int colSize){
        visited[vertex] = true;
        for(int i=0;i<colSize;i++){
            int value = isConnected[vertex][i];
            if(value==0){
                continue;
            }
            if(!visited[i]){
                dfs(i,visited,isConnected,colSize);
            }
        }
    }
}