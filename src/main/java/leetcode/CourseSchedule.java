package leetcode;

import java.util.*;

class CourseSchedule {

    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{1,0},{0,1}}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Edge case: No prerequisites, so all courses can be finished
        if(prerequisites.length==0){
            return true;
        }

        Map<Integer, List<Integer>> graph = buildGraph(numCourses,prerequisites);
        return canFinishAllCourses(graph);
    }

    private static Map<Integer,List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=0;i<numCourses;i++){
            graph.put(i,new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int c1 = arr[0];
            int c2 = arr[1];
            graph.get(c2).add(c1);
        }

        return graph;
    }

    private static boolean canFinishAllCourses(Map<Integer,List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean[] pathVisited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            boolean cycle = hasCycleDFS(i, graph, visited,pathVisited);
            if(cycle){
                return false;
            }
        }
        return true;
    }

    private static boolean hasCycleDFS(Integer start,Map<Integer,List<Integer>> graph,boolean[] visited,boolean[] pathVisited){
        if(pathVisited[start]){
            return true;
        }

        if(visited[start]) {
            return false;
        }

        visited[start] = true;
        pathVisited[start] = true;
        for (Integer adjNodes : graph.get(start)){
            if(hasCycleDFS(adjNodes,graph,visited,pathVisited)) {
                return true;
            }
        }

        pathVisited[start] = false;
        return false;
    }
}