package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BalancedBinaryTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        int diff =  Math.abs(left-right);

        return (diff==0 || diff==1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left,right) + 1;
    }
}