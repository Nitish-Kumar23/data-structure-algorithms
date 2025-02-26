package leetcode;

import java.util.*;

class CalcEquation {

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        equations.add(Arrays.asList("a","c"));
        equations.add(Arrays.asList("d","e"));

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","c"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));
        queries.add(Arrays.asList("a","d"));

        System.out.println(Arrays.toString(calcEquation(equations,new double[]{2.0,3.0,6.0,1.0},queries)));
    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String,Double>> graph = buildGraph(equations,values);
        return calcEquation(graph,queries);
    }

    private static Map<String, Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, Map<String,Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> subList = equations.get(i);
            String a = subList.get(0);
            String b = subList.get(1);
            Double value = values[i];

            graph.putIfAbsent(a,new HashMap<>());
            graph.putIfAbsent(b,new HashMap<>());

            graph.get(a).put(b,value); // a/b value
            graph.get(b).put(a,1/value); // b/a value
        }
        return graph;
    }

    private static double[] calcEquation(Map<String, Map<String,Double>> graph,List<List<String>> queries){
        double[] response = new double[queries.size()];
        int i = 0;
        for(List<String> list : queries){
            String a = list.get(0);
            String b = list.get(1);

            double value = calculateDivisionDFS(a,b,graph);
            response[i++] = value;
        }
        return response;
    }

    private static double calculateDivisionBFS(String start, String end,Map<String, Map<String,Double>> graph){
        if(!graph.containsKey(start) || !graph.containsKey(end)){
            return -1.0;
        }

        if(start.equals(end)){
            return 1.0;
        }

        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start,1.0));
        visited.add(start);
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            Map<String,Double> adjNodes = graph.get(current.curStr);
            for(Map.Entry<String, Double> e : adjNodes.entrySet()){
                String neighbour = e.getKey();
                double currentProduct = current.currProduct;
                double weight = e.getValue();
                double newProduct = currentProduct * weight;
                if(end.equals(neighbour)){
                    return newProduct;
                }
                if(!visited.contains(neighbour)) {
                    queue.add(new Pair(neighbour,newProduct));
                    visited.add(neighbour);
                }
            }
        }
        return -1.0;
    }

    private static double calculateDivisionDFS(String start, String end,Map<String, Map<String,Double>> graph) {
        if(!graph.containsKey(start) || !graph.containsKey(end)){
            return -1.0;
        }

        if(start.equals(end)){
            return 1.0;
        }

        Set<String> visited = new HashSet<>();
        return dfs(start,end,graph,visited,1.0);
    }

    private static double dfs(String start, String end, Map<String, Map<String, Double>> graph, Set<String> visited,Double product) {
        if(start.equals(end)){
            return product;
        }

        visited.add(start);
        for (Map.Entry<String,Double> entry : graph.get(start).entrySet()){
            String str = entry.getKey();
            if(visited.contains(str)){
                continue;
            }
            Double weight = entry.getValue();
            double ans = dfs(str,end,graph,visited,weight*product);
            if(ans!=-1.0){
                return ans;
            }
        }
        return -1.0;
    }

    private static class Pair {

        private String curStr;

        private double currProduct;

        public Pair(String curStr, double currProduct) {
            this.curStr = curStr;
            this.currProduct = currProduct;
        }
    }
}