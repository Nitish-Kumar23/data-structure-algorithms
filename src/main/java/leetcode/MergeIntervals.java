package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeIntervals {

    public static void main(String[] args) {
        int[][] response = merge(new int[][]{{1,3},{2,5},{8,10},{15,18}});
        for (int[] arr : response){
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    public static int[][] merge(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(i->i[0]));
        List<int[]> list = new ArrayList<>();
        int[] newInterval = arr[0];
        list.add(newInterval);

        for (int[] interval : arr){
            if(interval[0]<=newInterval[1]){
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }else {
                list.add(interval);
                newInterval = interval;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}