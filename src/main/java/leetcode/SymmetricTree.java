package leetcode;

import baseclass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode node1,TreeNode node2) {
        if(node1==null && node2==null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        if(node1.val!=node2.val){
            return false;
        }
        return isSymmetric(node1.left,node2.right) && isSymmetric(node2.left,node1.right);
    }

    public boolean isSymmetricQueue(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1==null && node2==null){
                continue;
            }
            if(node1==null || node2==null){
                return false;
            }
            if(node1.val!=node2.val){
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);

            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

}
