package Leetcode;

public class MaxArea {

    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int i=0, j=1;
        while(j<height.length){
            int area = (j-i) * Math.min(height[i],height[j]);
            if(area>maxArea){
                maxArea = area;
            }
            if(height[j]>height[i]){
                i=j;
                j++;
                continue;
            }
            j++;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,2,1}));
    }
}
