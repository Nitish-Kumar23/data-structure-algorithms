package leetcode;

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    /**
     * Pre-order traversal - iterative
     *
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     *
     * Recursive - pre order
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalV1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if(root==null){
            return;
        }
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }

}
