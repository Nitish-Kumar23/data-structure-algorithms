package leetcode;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
        System.out.println(isHappyV1(2));
    }

    //https://leetcode.com/problems/happy-number/
    public static boolean isHappy(int n) {
        Map<Integer,Boolean> map = new HashMap<>();
        int square=0;
        while (true){
            if(map.containsKey(n)){
                return false;
            }
            square = getSquareSumOfDigits(n);
            if(square==1){
                return true;
            }
            map.put(n,true);
            n = square;
        }
    }

    /**
     * slow and fast pointer approach (based on linked list) 
     * kind of similar to hashmap -- if slow and fast pointer meet then it's not a happy number
     * if square of digits is equal to 1 then it's a happy number
     * @param n
     * @return
     */
    public static boolean isHappyV1(int n) {
        int slow = getSquareSumOfDigits(n);
        int fast = getSquareSumOfDigits(n);
        while (true){
            slow = getSquareSumOfDigits(slow);
            fast = getSquareSumOfDigits(getSquareSumOfDigits(fast));
            if(slow==1||fast==1){
                return true;
            }
            if(slow==fast){
                return false;
            }
        }
    }

    public static int getSquareSumOfDigits(int n){
        int sum = 0;
        while(n!=0){
            int rem = n%10;
            sum = sum+(rem*rem);
            n = n/10;
        }
        return sum;
    }

}
