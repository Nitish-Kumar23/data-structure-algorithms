package models;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        adjVertices = new HashMap<>();
    }

    private Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    private void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public void addVertex(Vertex v){
        adjVertices.putIfAbsent(v,new ArrayList<>());
    }

    public void removeVertex(Vertex v){
        List<Vertex> adjVerticesList = adjVertices.get(v);
        for (Vertex vertex : adjVerticesList){
            adjVertices.get(vertex).remove(v);
        }
        adjVertices.remove(v);
    }

    public void addEdge(Vertex v1, Vertex v2){
        if(v1==null || v2==null){
            return;
        }

        List<Vertex> v1Vertices = adjVertices.get(v1);
        if(v1Vertices==null){
            System.out.println("invalid vertex v1 : " + v1.getLabel());
            return;
        }

        List<Vertex> v2Vertices = adjVertices.get(v2);
        if(v2Vertices==null){
            System.out.println("invalid vertex v2 : " + v2.getLabel());
            return;
        }
        v1Vertices.add(v2);
        v2Vertices.add(v1);
    }

    public void removeEdge(Vertex v1, Vertex v2){
        if(v1==null || v2==null){
            return;
        }

        List<Vertex> v1Vertices = adjVertices.get(v1);
        if(v1Vertices==null){
            System.out.println("invalid vertex v1 : " + v1.getLabel());
            return;
        }

        List<Vertex> v2Vertices = adjVertices.get(v2);
        if(v2Vertices==null){
            System.out.println("invalid vertex v2 : " + v2.getLabel());
            return;
        }

        v1Vertices.remove(v2);
        v2Vertices.remove(v1);

    }

    public List<Vertex> getAdjacencyVertices(Vertex vertex){
        return adjVertices.get(vertex);
    }

    public Set<Vertex> breadthFirstSearchTraversal(Vertex root){
        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        visited.add(root);
        queue.add(root);

        while (!queue.isEmpty()){
            Vertex vertex = queue.poll();
            for (Vertex v : this.getAdjacencyVertices(vertex)){
                if(!visited.contains(v)){
                    visited.add(v);
                    queue.add(v);
                }
            }
        }

        return visited;

    }

    public List<Vertex> bfsShortestPath(Vertex source,Vertex target){
        Map<Vertex,Vertex> predecessorMap = bfsTraversalWithPathInfo(source);

        return recreatePath(predecessorMap,target);
    }

    private Map<Vertex,Vertex> bfsTraversalWithPathInfo(Vertex source){
        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex,Vertex> predecessorMap = new HashMap<>();
        visited.add(source);
        queue.add(source);
        predecessorMap.put(source,null);

        while (!queue.isEmpty()){
            Vertex currentvertex = queue.poll();
            for (Vertex neighbour : this.getAdjacencyVertices(currentvertex)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                    predecessorMap.put(neighbour,currentvertex);
                }
            }
        }

        return predecessorMap;

    }

    private List<Vertex> recreatePath(Map<Vertex,Vertex> predecessorMap,Vertex target){
        List<Vertex> path = new ArrayList<>();
        Vertex current = target;
        path.add(current);
        while (current!=null){
            Vertex predecessorVertex = predecessorMap.get(current);
            path.add(predecessorVertex);
            current = predecessorVertex;
        }

        Collections.reverse(path);

        return path;
    }

    public Set<Vertex> depthFirstSearchTraversal(Vertex root){
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Vertex vertex = stack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for (Vertex v : this.getAdjacencyVertices(vertex)){
                    stack.push(v);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        System.out.println(printGraph(5, new int[][]{{0,1},{0,4},{4,1},{4,3},{1,3},{1,2},{3,2}}));

        Graph graph = new Graph();

        Vertex bob = new Vertex("Bob");
        Vertex alice = new Vertex("Alice");
        Vertex maria = new Vertex("Maria");
        Vertex mark = new Vertex("Mark");
        Vertex rob = new Vertex("Rob");
        Vertex giyan = new Vertex("Giyan");

        graph.addVertex(bob);
        graph.addVertex(alice);
        graph.addVertex(maria);
        graph.addVertex(mark);
        graph.addVertex(rob);
        graph.addVertex(giyan);
        graph.addEdge(bob,alice);
        graph.addEdge(bob,rob);
        graph.addEdge(alice,mark);
        graph.addEdge(rob,mark);
        graph.addEdge(alice,maria);
        graph.addEdge(rob,maria);
        graph.addEdge(rob,giyan);

        System.out.println(graph.getAdjacencyVertices(bob).toString());

        graph.removeEdge(alice,bob);
        graph.removeEdge(rob,bob);

        System.out.println("adjacency vertices : " + graph.getAdjacencyVertices(alice).toString());

        graph.removeVertex(maria);

        System.out.println(graph.breadthFirstSearchTraversal(bob));
        System.out.println("breadth first search traversal : " + graph.breadthFirstSearchTraversalV1(alice));

        System.out.println(graph.bfsShortestPath(mark,bob));

        System.out.println(graph.depthFirstSearchTraversal(rob));

        System.out.println("Graph" + graph);
    }

    private Set<Vertex> breadthFirstSearchTraversalV1(Vertex root){
        Set<Vertex> visited = new LinkedHashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);

        while (!queue.isEmpty()){
            List<Vertex> adjacentVertices =  getAdjacencyVertices(queue.poll());
            for (Vertex v : adjacentVertices){
                if(visited.contains(v)){
                    continue;
                }
                queue.add(v);
                visited.add(v);
            }
        }

        return visited;
    }

    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }

        for (int[] arr : edges){
            int sourceElement = arr[0];
            int targetElement = arr[1];
            list.get(sourceElement).add(targetElement);
            list.get(targetElement).add(sourceElement);
        }

        return list;
    }



    @Override
    public String toString() {
        return "Graph{" +
                "adjVertices=" + adjVertices +
                '}';
    }
}
