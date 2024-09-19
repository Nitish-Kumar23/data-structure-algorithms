package models;

import java.util.*;

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

    public Set<Vertex> depthFirstSearchTraversal(Vertex root){
        Set<Vertex> visited = new LinkedHashSet<>();
        Stack<Vertex> IStack = new Stack<>();
        IStack.push(root);

        while (!IStack.isEmpty()){
            Vertex vertex = IStack.pop();
            if(!visited.contains(vertex)){
                visited.add(vertex);
                for (Vertex v : this.getAdjacencyVertices(vertex)){
                    IStack.push(v);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
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

        System.out.println(graph.getAdjacencyVertices(bob).toString());

        graph.removeVertex(maria);

        System.out.println(graph.breadthFirstSearchTraversal(bob));


        System.out.println(graph.depthFirstSearchTraversal(rob));

        System.out.println("Graph" + graph);
    }
}
