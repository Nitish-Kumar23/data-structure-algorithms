package leetcode;

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                if(i==levelSize-1){
                    result.add(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        rightSideViewDFS(root,0,result);
        return result;
    }

    public void rightSideViewDFS(TreeNode node, int level, List<Integer> result){
        if(node==null){
            return;
        }
        if(result.size()<=level){
            result.add(node.val);
        }
        level++;
        rightSideViewDFS(node.right,level,result);
        rightSideViewDFS(node.left,level,result);
    }

}
