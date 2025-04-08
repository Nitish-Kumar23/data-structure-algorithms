package leetcode;

import java.util.Arrays;

class RangeAddition {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getModifiedArray(5,new int[][]{{1,3,2},{2,4,3},{0,2,-2}})));
    }
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] output = new int[length];
        for(int i=0;i<updates.length;i++){
            int[] sub = updates[i];
            int start = sub[0];
            int end = sub[1];
            int inc = sub[2];

            output[start] = output[start] + inc;
            if(end+1<length){
                output[end+1] = output[end+1]-inc;
            }
        }

        int sum = 0;
        for(int i=0;i<length;i++){
            output[i] = output[i] + sum;
            sum = output[i];
        }

        return output;
    }
}