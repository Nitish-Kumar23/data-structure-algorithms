package leetcode;

import java.util.*;

class WordLadderI {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("most");
        list.add("mist");
        list.add("miss");
        list.add("lost");
        list.add("fist");
        list.add("fish");
        List<String> path = ladderLengthWithPath("lost","miss",list);
        System.out.println(path);
        System.out.println(path.size());
    }
    
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(Objects.equals(beginWord, endWord) || !wordList.contains(endWord)) {
            return 0;
        }
        if(!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        Map<String, Set<String>> adjListMap = getAdjacencyListMap(wordList);
        return traversal(beginWord,endWord,adjListMap);
    }

    public static List<String> ladderLengthWithPath(String beginWord, String endWord, List<String> wordList) {
        if(Objects.equals(beginWord, endWord) || !wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        if(!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        Map<String, Set<String>> adjListMap = getAdjacencyListMap(wordList);
        return traversalWithPath(beginWord,endWord,adjListMap);
    }

    private static int traversal(String beginWord, String endWord, Map<String, Set<String>> adjListMap) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i=0;i<size;i++){
                String element = queue.poll();
                if(element.equals(endWord)){
                    return count;
                }
                for (String val : adjListMap.get(element)){
                    if(!visited.contains(val)){
                        visited.add(val);
                        queue.add(val);
                    }
                }

            }
        }

        return 0;
    }

    private static List<String> traversalWithPath(String beginWord, String endWord, Map<String, Set<String>> adjListMap) {
        Map<String,String> targetToSourceMap = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        targetToSourceMap.put(beginWord,"");
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count++;
            for (int i=0;i<size;i++){
                String element = queue.poll();
                if(element.equals(endWord)){
                    return recreatePath(targetToSourceMap,endWord);
                }
                for (String val : adjListMap.get(element)){
                    if(!visited.contains(val)){
                        visited.add(val);
                        queue.add(val);
                        targetToSourceMap.put(val,element);
                    }
                }

            }
        }

        return recreatePath(targetToSourceMap,endWord);
    }

    private static List<String> recreatePath(Map<String, String> targetToSourceMap,String endWord) {
        if(!targetToSourceMap.containsKey(endWord)){
            return new ArrayList<>();
        }
        String dest = endWord;
        List<String> reversePath = new ArrayList<>();
        while (dest!=""){
            reversePath.add(dest);
            dest = targetToSourceMap.get(dest);
        }
        Collections.reverse(reversePath);
        return reversePath;
    }


    private static Map<String, Set<String>> getAdjacencyListMap(List<String> wordList) {
        Map<String,Set<String>> adjListMap = new HashMap<>();
        for (String str : wordList){
            adjListMap.put(str,new HashSet<>());
        }


        for (String str : wordList){
            prepareAjdListMap(str,adjListMap,wordList);
        }

        return adjListMap;

    }

    private static void prepareAjdListMap(String word,Map<String, Set<String>> adjListMap,List<String> wordList) {
        for(String val : wordList){
            if(val.equals(word)){
                continue;
            }

            boolean possibleAdjacent = possibleAdjacent(val,word);
            if(possibleAdjacent){
                // directional edge
                adjListMap.get(word).add(val);
                adjListMap.get(val).add(word);
            }
        }

    }

    private static boolean possibleAdjacent(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false; // More than one character differs
                }
            }
        }
        return count == 1; // Must differ by exactly one character
    }

}