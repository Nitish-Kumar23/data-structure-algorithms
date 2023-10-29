package Leetcode;

public class JumpGameII {

    // [2,3,1,1,4]
    // [2,3,0,1,4]
    public static int jumpHelper(int[] arr, int start) {
        if(start==arr.length-1){
            return 0;
        }
        if(arr[start]==0){
            return 0;
        }
        int globalMin = Integer.MAX_VALUE;
        for (int i = start; i < arr[start]+start; i++) {
            int minJump = jumpHelper(arr, i + 1) + 1;
            if (minJump < globalMin) {
                globalMin = minJump;
            }
        }
        return globalMin;
    }

    public static int jumpV1(int[] arr){
        int[] output = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            output[i]=-1;
        }
        output[arr.length-1]=0;
        return getMinSteps(arr,0,output);
    }

    private static int getMinSteps(int[] arr, int start,int[] output) {
        if(output[start]!=-1){
            return output[start];
        }
        if(arr.length==1 || start==arr.length-1){
            return 0;
        }

        if(arr[start]==0){
            return Integer.MAX_VALUE;
        }
        int globalMin = Integer.MAX_VALUE;
        for (int count=1;count<=arr[start] && start+count<arr.length;count++){
            int minSteps = getMinSteps(arr,start+count,output);
            if(minSteps!=Integer.MAX_VALUE){
                minSteps++;
                globalMin = Math.min(globalMin,minSteps);
                output[start] = globalMin;
            }
        }
        return globalMin;
    }

    public static int jump(int[] arr){
        return jumpHelper(arr,0);
    }
    
    public static void main(String[] args) {
//        System.out.println(jump(new int[]{2,3,1,4,5}));
        System.out.println(jumpV1(new int[]{2,3,1,1,4}));
    }

}
