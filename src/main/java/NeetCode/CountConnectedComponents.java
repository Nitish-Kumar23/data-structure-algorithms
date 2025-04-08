package NeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://neetcode.io/problems/count-connected-components
 *
 */
class CountConnectedComponents {

    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        for(int i=0;i<n;i++){
            adjListMap.put(i,new ArrayList<>());
        }

        populateAdjacencyListMap(adjListMap,edges);
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }

            traversal(i,adjListMap,visited);
            count++;
        }

        return count;
    }

    private void traversal(int node,Map<Integer,List<Integer>> adjListMap,boolean[] visited){
        dfs(node,adjListMap,visited);
    }

    private void dfs(int node,Map<Integer,List<Integer>> adjListMap,boolean[] visited){
        if(visited[node]){
            return;
        }

        visited[node] = true;
        for(Integer neighbour : adjListMap.get(node)){
            dfs(neighbour,adjListMap,visited);
        }
    }

    private void populateAdjacencyListMap(Map<Integer,List<Integer>> adjListMap,int[][] edges){
        for(int[] d : edges){
            int source = d[0];
            int dest = d[1];
            adjListMap.get(source).add(dest);
            adjListMap.get(dest).add(source);
        }
    }
}
