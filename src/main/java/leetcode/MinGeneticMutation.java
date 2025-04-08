package leetcode;

import java.util.*;

class MinGeneticMutation {

    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT","AACCGCTA",new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}));
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        Map<String,List<String>> adjMap = createAdjMap(startGene,bank);
        return minMutation(startGene,endGene,adjMap);
    }

    private static int minMutation(String startGene,String endGene,Map<String,List<String>>  adjMap){
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);
        int minMutation = 0;
        while(!queue.isEmpty()){
            boolean mutation = false;
            int pollSize = queue.size();
            for(int i=0;i<pollSize;i++){
                String s = queue.poll();
                if(s.equals(endGene)){
                    return minMutation;
                }
                for(String adj : adjMap.get(s)){
                    if(!visited.contains(adj)){
                        queue.add(adj);
                        visited.add(adj);
                        mutation = true;
                    }
                }
            }

            if(mutation==true){
                minMutation++;
            }
        }

        return -1;
    }

    private static Map<String,List<String>> createAdjMap(String startGene,String[] bank){
        Map<String,List<String>> adjMap = new HashMap<>();
        adjMap.put(startGene,new ArrayList<>());
        for(String s : bank){
            adjMap.put(s,new ArrayList<>());
        }


        // create adj map for start gene first
        for(String s : bank){
            boolean geneticMutation = isGeneticMutation(s,startGene);
            if(geneticMutation){
                adjMap.get(startGene).add(s);
                adjMap.get(s).add(startGene);
            }
        }

        // create adj map for start gene first
        for(int i=0;i<bank.length;i++){
            for(int j=i+1;j<bank.length;j++){
                boolean geneticMutation = isGeneticMutation(bank[i],bank[j]);
                if(geneticMutation){
                    adjMap.get(bank[i]).add(bank[j]);
                    adjMap.get(bank[j]).add(bank[i]);
                }
            }
        }

        return adjMap;
    }

    private static boolean isGeneticMutation(String s1,String s2){
        int diffCharacters = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i)){
                continue;
            }
            diffCharacters++;
            if(diffCharacters>1){
                return false;
            }
        }
        return diffCharacters==1;
    }
}