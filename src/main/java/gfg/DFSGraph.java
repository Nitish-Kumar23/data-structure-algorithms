package gfg;

import java.util.*;

class DFSGraph {
    // Function to return a list containing the DFS traversal of the graph.
    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<>();
        
        stack.push(0);

        while (!stack.isEmpty()){
            Integer element = stack.pop();
            if(!visited.contains(element)){
                visited.add(element);
                list.add(element);
                List<Integer> subList = adj.get(element);
                for (int i=subList.size()-1;i>=0;i--){
                    stack.push(subList.get(i));
                }
            }
        }
        
        return list;
        
        
    }
}