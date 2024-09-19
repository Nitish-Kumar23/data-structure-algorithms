package leetcode;

import models.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class kthSmallestElementST {

    private int count = 0;

    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallest(root,list);
        return list.get(k-1);
    }

    public void kthSmallest(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        kthSmallest(node.left,list);
        list.add(node.val);
        kthSmallest(node.right,list);
    }

    public int kthSmallestStack(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (true){
            stack.push(current);
            while (current.left!=null){
                current = current.left;
                stack.push(current);
            }
            stack.pop();
            if(--k==0){
                return current.val;
            }
            while (current.right==null){
                current = stack.pop();
                if(--k==0){
                    return current.val;
                }
            }

            current = current.right;
        }
    }

    public int kthSmallestOp(TreeNode node,int k){
        inOrderTraversal(node,k);
        return result;
    }

    public void inOrderTraversal(TreeNode root, int k) {
        if(root==null){
            return;
        }

        kthSmallestOp(root.left,k);
        count++;
        if(count==k){
            result = root.val;
        }
        kthSmallestOp(root.right,k);
    }

}
