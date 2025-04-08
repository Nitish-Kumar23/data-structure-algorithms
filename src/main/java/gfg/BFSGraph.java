package gfg;

import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 *
 */
class BFSGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(0, 2)));
        list.add(new ArrayList<>(Arrays.asList(2, 1)));
        list.add(new ArrayList<>(Arrays.asList(0, 1)));

        System.out.println(bfsOfGraph(5,list));

    }
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

    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> response = new ArrayList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            response.add(queue.peek());
            List<Integer> adjList = adj.get(queue.poll());
            for(Integer element : adjList){
                if(response.contains(element)){
                    continue;
                }
                queue.add(element);
            }
        }

        return response;
    }
}