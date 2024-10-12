package gfg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.geeksforgeeks.org/problems/number-of-provinces/1
 *
 */
class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int provinceCount = 0;
        for(int i=0;i<adj.size();i++){
            if(!visited[i]){
                provinceCount++;
                dfs(i,visited,adj);
            }
        }
        
        return provinceCount;
    }
    
    private static void dfs(int vertex,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[vertex] = true;
        List<Integer> sub =  adj.get(vertex);
        for(int i=0;i<sub.size();i++){
            if(sub.get(i)==0){
                continue;
            }
            if(!visited[i]){
                dfs(i,visited,adj);
            }
        }
    }
}