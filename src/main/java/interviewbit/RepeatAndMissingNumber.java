package interviewbit;

import java.util.Arrays;

public class RepeatAndMissingNumber {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(repeatedNumber(new int[]{3,1,2,5,3})));
    }
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] repeatedNumber(final int[] arr) {
        // consider z : missing number , y : repeating number
        int n = arr.length;
        long sumNRange = (long) n*(n+1)/2;
        long sumSquareNRange = (n*(n+1)*(2L *n + 1))/6;
        long actualSum = 0;
        long actualSquareSum = 0;
        for (int j : arr) {
            actualSum = actualSum + j;
            actualSquareSum = (actualSquareSum + ((long) j * (long) j));
        }

        // calculate difference of range sum and actual sum : z-y
        long diff = sumNRange - actualSum;
        long diffSquare = sumSquareNRange - actualSquareSum;
        long sumMR = diffSquare/diff;
        // Calculate missing and repeated number
        long missingNumber = (diff + sumMR) / 2;
        long repeatedNumber = missingNumber - diff;

        return new int[]{(int)repeatedNumber,(int)missingNumber};


    }
}
