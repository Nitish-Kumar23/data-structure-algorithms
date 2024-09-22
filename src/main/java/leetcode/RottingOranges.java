package leetcode;

import java.util.*;

class RottingOranges {
    public static int orangesRotting(int[][] grid) {
        
        /**
        [2,1,1]  [2,2,1]
        [1,2,0]  [2,2,0]
        [0,1,2]  [0,1,2]
        

        [0,0  1,1  2,2]
        
        t=2
        [2,1,1]
        [2,1,0]
        [0,2,1]
         */

        int rowSize = grid.length;
        int colSize = grid[0].length;


        int t =0;
        Set<String> set = new HashSet<>();
        while (true){
        Map<Integer,Integer> preStateVsCount = new HashMap<>();
        Map<Integer,Integer> stateVsCount = new HashMap<>();
        List<List<Integer>> indexesList = populateIndexList(grid,rowSize,colSize,preStateVsCount,set);

        for(List<Integer> list : indexesList){
            int row = list.get(0);
            int col = list.get(1);

            if(row-1>=0){
                if(grid[row-1][col]==1){
                    grid[row-1][col] = 2;
                }
            }
            if(row+1<rowSize){
                if(grid[row+1][col]==1){
                    grid[row+1][col]=2;
                }
            }
            if(col-1>=0 && grid[row][col-1]==1){
                grid[row][col-1]=2;
            }
            if(col+1<colSize && grid[row][col+1]==1){
                grid[row][col+1]=2;
            }
        }

        populatePostStateMap(grid,rowSize,colSize,stateVsCount);

        if(mapValueEquals(preStateVsCount,stateVsCount)){
            if(stateVsCount.containsKey(1) && stateVsCount.get(1)>0){
                return -1;
            }
            return t;
        }
        t++;

    }

    }

    private static boolean mapValueEquals(Map<Integer, Integer> preStateVsCount, Map<Integer, Integer> stateVsCount) {
        for (Map.Entry entry : preStateVsCount.entrySet()){
            int key = (int) entry.getKey();
            if(stateVsCount.containsKey(key)){
                if(stateVsCount.get(key) != preStateVsCount.get(key)){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;

    }

    private static List<List<Integer>> populateIndexList(int[][] grid,int rowSize,int colSize,Map<Integer,Integer> preStateVsCount,Set<String> set){

        List<List<Integer>> indexesList = new ArrayList<>();
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(grid[i][j]==1){
                    putOrUpdate(preStateVsCount,1);
                }
                if(grid[i][j]==2){
                    putOrUpdate(preStateVsCount,2);
                    String key = String.join("_",String.valueOf(i),String.valueOf(j));
                    if(set.contains(key)){
                        continue;
                    }
                    indexesList.add(Arrays.asList(i,j));
                    set.add(key);
                }
                if(grid[i][j]==0){
                    putOrUpdate(preStateVsCount,0);
                }
            }
        }
        return indexesList;
    }

    private static void populatePostStateMap(int[][] grid,int rowSize,int colSize,Map<Integer,Integer> stateVsCount){
        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(grid[i][j]==1){
                    putOrUpdate(stateVsCount,1);
                }
                if(grid[i][j]==2){
                    putOrUpdate(stateVsCount,2);
                }
                if(grid[i][j]==0){
                    putOrUpdate(stateVsCount,0);
                }
            }
        }
    }

    private static void putOrUpdate(Map<Integer,Integer> stateVsCount,Integer key){
        if(stateVsCount.containsKey(key)){
            stateVsCount.put(key,stateVsCount.get(key)+1);
        }
        else {
            stateVsCount.put(key,1);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(arr));
    }
}