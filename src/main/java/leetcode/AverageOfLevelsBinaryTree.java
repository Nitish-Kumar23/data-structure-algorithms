package leetcode;

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsBinaryTree {

    public void averageLevels(TreeNode root){
        LevelOrderTraversalBT levelOrderTraversalBT = new LevelOrderTraversalBT();
        List<List<Integer>> result = levelOrderTraversalBT.levelOrderQueue(root);

        getAverageTraversal(result);
    }

    private List<Double> getAverageTraversal(List<List<Integer>> result) {
        List<Double> output = new ArrayList<>();
        for (List<Integer> list : result){
            double sum = 0;
            for (Integer val : list){
                sum = sum+val;
            }
            output.add((sum / (double) list.size()));
        }
        return output;
    }

    public List<Double> averageLevelsOptimized(TreeNode root){
        List<Double> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            double lSum = 0;
            for(int i=0;i<level;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
               lSum = lSum + node.val;
            }
            result.add(lSum/level);
        }

        return result;
    }

}
