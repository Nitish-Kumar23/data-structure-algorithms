package leetcode;

import models.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }

        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode node,Integer lowerBound,Integer upperBound){
        if(node==null){
            return true;
        }

        if(lowerBound!=null ){
            if(node.val<=lowerBound){
                return false;
            }
        }

        if(upperBound!=null){
            if(node.val>=upperBound){
                return false;
            }
        }

        return isValidBST(node.left,lowerBound,node.val) && isValidBST(node.right,node.val,upperBound);
    }

}
