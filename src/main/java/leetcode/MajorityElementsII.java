package leetcode;

import java.util.*;

class MajorityElementsII {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> frequentElementsMap = new HashMap<>();
        int allowedSize = nums.length/3;

        // populate map which are candidates of occurrence of more than n/3 times
        for(int element : nums){
           frequentElementsMap.put(element,frequentElementsMap.getOrDefault(element,0)+1);
           if(frequentElementsMap.size()>2){
               decrementCountersInMap(frequentElementsMap);
           }
        }

        // calculate actual occurrence of elements found in map
        return elementsWithGreaterOccurrence(nums, frequentElementsMap, allowedSize);

    }

    private static List<Integer> elementsWithGreaterOccurrence(int[] nums, Map<Integer, Integer> frequentElementsMap, int allowedSize) {
        Map<Integer,Integer> occurenceMap = new HashMap<>();
        for (int element : nums){
            if(frequentElementsMap.containsKey(element)) {
                occurenceMap.put(element,occurenceMap.getOrDefault(element,0)+1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : occurenceMap.entrySet()){
            if(entry.getValue()> allowedSize){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private void decrementCountersInMap(Map<Integer,Integer> frequentElementsMap){
        Set<Integer> zeroValueSet = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry : frequentElementsMap.entrySet()){
            int val = entry.getValue();
            entry.setValue(val-1);
            if(entry.getValue()==0){
                zeroValueSet.add(entry.getKey());
            }
        }

        for (Integer key : zeroValueSet) {
            frequentElementsMap.remove(key);
        }
    }
}