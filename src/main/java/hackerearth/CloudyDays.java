package hackerearth;

import java.util.*;

/**
 *
 * https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/cloudy-days-82a872ec/
 *
 */
class CloudyDays {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input
        **/

        Scanner scanner = new Scanner(System.in);

        // Read inputs
        int numCities = scanner.nextInt();
        int numRoads = scanner.nextInt();
        int fuel = scanner.nextInt();
        int startCity = scanner.nextInt();

        Map<Integer, List<Integer>> adjVertices = new HashMap<>();
        for(int i=0;i<numCities;i++){
            adjVertices.putIfAbsent(i,new ArrayList<>());
        }

        for(int i=0;i<numRoads;i++){
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            List<Integer> sourceListCities = adjVertices.get(source);
            List<Integer> destListCities = adjVertices.get(dest);

            sourceListCities.add(dest);
            destListCities.add(source);
        }

        Set<Integer> visited = new HashSet<>();
        int reachableCities = dfs(startCity,adjVertices,visited,fuel);

        System.out.println(reachableCities);
    }

    private static int dfs(int start,Map<Integer,List<Integer>> adjVertices,Set<Integer> visited,   int fuel){
        int count = 1;
        visited.add(start);
        for(Integer element : adjVertices.get(start)){
            if(!visited.contains(element) && fuel-1>=0){
                count = count + dfs(element,adjVertices,visited,fuel-1);
            }
        }
        return count;
    }


}
