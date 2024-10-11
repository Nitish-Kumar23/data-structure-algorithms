package algopractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomAlgorithmSelector {

    private static final List<String> algorithms = Arrays.asList("BINARY_SEARCH","SELECTION_SORT","QUICK_SORT","MERGE_SORT","BST_IMPLEMENTATION","DNF_ALGORITHM");

    public static final Random random = new Random();
    public static void main(String[] args) {
        System.out.println(randomAlgorithm());
    }

    private static List<String> randomAlgorithm() {
        List<String> result = new ArrayList<>();
        if(algorithms.isEmpty()){
            return result;
        }

        result.add(algorithms.get(getRandomIndex(0,algorithms.size())));
        result.add(algorithms.get(getRandomIndex(0,algorithms.size())));
        return  result;
    }

    private static Integer getRandomIndex(Integer minBound, Integer maxBound) {
        return random.nextInt(minBound,maxBound);
    }

}
