package leetcode;

import java.util.Arrays;

class ClimbingStairs {
    
    public int climbStairs(int n) {
        if(n==0 || n==1 ||n==2){
            return n;
        }

        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        return climbStairsWays(n,arr);
    }

    private int climbStairsWays(int n,int[] arr){
        if(arr[n]!=-1){
            return arr[n];
        }

        if(n==0 || n==1 || n==2){
            return arr[n];
        }

        arr[n] = climbStairsWays(n-1,arr) + climbStairsWays(n-2,arr);
        return arr[n];
    }
}