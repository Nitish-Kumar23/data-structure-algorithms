package leetcode;

import baseclass.TreeNode;

import java.util.*;

public class LevelOrderTraversalBT {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderTraversal(root,result,0);
        return result;
    }

    private void levelOrderTraversal(TreeNode node, List<List<Integer>> result, int level) {
        if(node==null){
            return;
        }
        checkListAndAdd(node.val,result,level);
        level++;
        levelOrderTraversal(node.left,result,level);
        levelOrderTraversal(node.right,result,level);
    }

    private void checkListAndAdd(int val, List<List<Integer>> result,int level) {
        if(result.size()<=level){
            result.add(new ArrayList<>(Collections.singleton(val)));
            return;
        }
        List<Integer> list = result.get(level);
        list.add(val);
        result.set(level,list);
    }

    public List<List<Integer>> levelOrderQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();
            for(int i=0;i<level;i++){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                currentLevelList.add(node.val);
            }
            result.add(currentLevelList);
        }

        return result;
    }

}
