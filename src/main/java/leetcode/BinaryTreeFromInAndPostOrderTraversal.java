package leetcode;

import models.TreeNode;

import java.util.Arrays;

public class BinaryTreeFromInAndPostOrderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0){
            return null;
        }

        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);

        int index = 0;
        for (int i=0;i<inorder.length;i++){
            if(inorder[i]==rootVal){
                index = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(inorder,index+1,inorder.length),Arrays.copyOfRange(postorder,index,postorder.length-1));

        return root;
    }

}
