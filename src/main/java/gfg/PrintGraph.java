package gfg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1
 *
 */
public class PrintGraph {

    public static void main(String[] args) {
        System.out.println(printGraph(5, new int[][]{{0,1},{0,4},{4,1},{4,3},{1,3},{1,2},{3,2}}));
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

}
