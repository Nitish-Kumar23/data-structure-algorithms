package leetcode;

import java.util.*;

class PathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        Map<Integer, Integer> targetVsSourceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjListMap.put(i, new ArrayList<>());
        }

        populateAdjacencyListMap(edges, adjListMap);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                System.out.println(buildPathToDestinationNode(targetVsSourceMap, source, destination));
                return true;
            }

            for (Integer neighbour : adjListMap.get(node)) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                targetVsSourceMap.put(neighbour, node);
                visited.add(neighbour);
                queue.add(neighbour);

            }
        }

        return false;
    }

    private List<Integer> buildPathToDestinationNode(Map<Integer, Integer> targetVsSourceMap, int source, int destination) {
        List<Integer> list = new ArrayList<>();
        while (source != destination) {
            list.add(destination);
            destination = targetVsSourceMap.get(destination);
        }
        list.add(source);
        Collections.reverse(list);
        return list;
    }

    private void populateAdjacencyListMap(int[][] edges, Map<Integer, List<Integer>> adjListMap) {
        for (int[] arr : edges) {
            int source = arr[0];
            int dest = arr[1];
            adjListMap.get(source).add(dest);
            adjListMap.get(dest).add(source);
        }
    }
}