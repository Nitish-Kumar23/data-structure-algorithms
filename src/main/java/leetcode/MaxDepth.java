package leetcode;

import baseclass.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int dLeft = maxDepth(root.left);
        int dRight = maxDepth(root.right);
        return Math.max(dLeft,dRight)+1;
    }

}
