package Leetcode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum implements Serializable {

    public static List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(numbers);
        //if first element is exceeding zero then no valid triplets
        if (numbers[0] > 0) {
            return output;
        }

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            //skip duplicates
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int start = i + 1;
            int end = numbers.length - 1;

            while (start < end) {
                List<Integer> list = new ArrayList<>();
                int sum = numbers[start] + numbers[i] + numbers[end];

                if (sum == 0) {
                    output.add(Arrays.asList(numbers[start], numbers[i], numbers[end]));

                    while (start < end && numbers[start] == numbers[start + 1]) {
                        start++;
                    }

                    while (start < end && numbers[end] == numbers[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }

}
