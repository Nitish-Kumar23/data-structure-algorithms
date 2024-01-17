package leetcode;

import baseclass.TreeNode;

public class DiameterBinaryTree {

    private Integer maxDiameter = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        height(root);
        return maxDiameter-1;
    }

    public int height(TreeNode node){
        if(node==null){
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        int diameter = lHeight + rHeight + 1;
        maxDiameter = Math.max(maxDiameter,diameter);
        return 1 + Math.max(lHeight,rHeight);

    }

}
