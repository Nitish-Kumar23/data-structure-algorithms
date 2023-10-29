package Leetcode;

public class PrintNameNTimes {

    public static void main(String[] args) {
        printName(0,5);
    }

    private static void printName(int currentCount,int n) {
        if(currentCount>=n){
            return;
        }

        System.out.println("Nitish");
        printName(++currentCount,n);
    }
}
