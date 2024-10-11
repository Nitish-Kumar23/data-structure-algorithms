package gfg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 *
 */
class BFSGraph {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(0);
        list.add(0);
        
        while(!queue.isEmpty()){
            List<Integer> adjList = adj.get(queue.poll());
            for(Integer element : adjList){
                if(list.contains(element)){
                    continue;
                }
                list.add(element);
                queue.add(element);
            }
        
        }
        
        return list;
    }
}