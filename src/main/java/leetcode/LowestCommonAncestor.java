package leetcode;

import baseclass.TreeNode;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }

        if(root==p || root==q){
            return root;
        }

        TreeNode lRes = lowestCommonAncestor(root.left,p,q);
        TreeNode rRes = lowestCommonAncestor(root.right,p,q);
        if(lRes!=null && rRes!=null){
            return root;
        }
        return lRes!=null ? lRes : rRes;
    }

}
