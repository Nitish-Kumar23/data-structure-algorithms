package gfg;

import java.util.ArrayList;
import java.util.Stack;

class TopoSortDFS {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<adj.size();i++){
            dfs(i,visited,stack,adj);
        }
        
        ArrayList<Integer> response = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            response.add(stack.pop());
        }
        return response;
    }
    
    private static void dfs(int start,boolean[] visited,Stack<Integer> stack,ArrayList<ArrayList<Integer>> adj){
        if(visited[start]){
            return;
        }
        
        visited[start] = true;
        for(Integer neighbour : adj.get(start)){
            if(visited[neighbour]){
                continue;
            }
            dfs(neighbour,visited,stack,adj);
        }
        stack.push(start);
    }
}