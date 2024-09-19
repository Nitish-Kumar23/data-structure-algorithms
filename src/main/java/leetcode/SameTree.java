package leetcode;

import models.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(isAnyNull(p,q)){
            return false;
        }
        if(p==null && q==null){
            return true;
        }
        if(p.val!=q.val){
            return false;
        }
        boolean lIsSameTree = isSameTree(p.left,q.left);
        boolean rIsSameTree = isSameTree(p.right,q.right);
        return lIsSameTree && rIsSameTree;
    }

    public boolean isAnyNull(TreeNode p, TreeNode q){
        if(p==null && q!=null){
            return true;
        }
        if(p!=null && q==null){
            return true;
        }
        return false;
    }

}
