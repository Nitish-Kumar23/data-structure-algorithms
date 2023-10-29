package Leetcode;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,0,0}));
    }

    // 2,3,1,0,4
    // 3,2,1,0,4
    // 2,0,0
    private static boolean canJump(int[] arr) {
        int furthestIndex = arr.length-1;
        int currentPointer = furthestIndex - 1;
        while (currentPointer>=0){
            int index = currentPointer + arr[currentPointer];
            if(index>=furthestIndex){
                furthestIndex=currentPointer;
                currentPointer--;
                continue;
            }
            currentPointer--;
        }
        if(furthestIndex==0){
            return true;
        }
        return false;
    }
}
