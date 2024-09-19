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
class BinaryTreeMaximumPathSum {

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

    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateGlobalMax(root);
        return globalMax;
    }

    public int calculateGlobalMax(TreeNode root){
        if(root==null){
            return 0;
        }

        int lSum = Math.max(0,calculateGlobalMax(root.left));
        int rSum = Math.max(0,calculateGlobalMax(root.right));

        globalMax = Math.max(globalMax,root.val + lSum + rSum);

        return root.val + Math.max(lSum,rSum);
    }
}