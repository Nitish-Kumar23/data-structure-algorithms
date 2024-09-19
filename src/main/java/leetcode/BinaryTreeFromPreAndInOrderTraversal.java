package leetcode;

import models.TreeNode;

import java.util.Arrays;

public class BinaryTreeFromPreAndInOrderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
       if(preorder==null || preorder.length==0){
           return null;
       }

       int rootVal = preorder[0];
       TreeNode root = new TreeNode(rootVal);
       int index = 0;
       for (int i=0;i<inorder.length;i++){
           if(inorder[i]==rootVal){
               index = i;
               break;
           }
       }

       root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1), Arrays.copyOfRange(inorder,0,index));
       root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

       return root;
    }

    public static void main(String[] args){
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }

}
