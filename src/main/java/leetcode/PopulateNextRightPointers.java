package leetcode;

import baseclass.TreeNode;
import binarytree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {

    public static class Node{
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            for (int i=0;i<levelSize;i++){
                Node node = queue.poll();
                if(i==levelSize-1){
                    node.next = null;
                }else {
                    node.next = queue.peek();
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public Node connectOptimized(Node root) {
        if(root==null){
            return null;
        }
        connect(root.left,root.right);
        connect(root.right,root.next);
        return root;
    }

    private void connect(Node node, Node ans) {
        if(node==null){
            return;
        }
        node.next = ans;
        connect(node.left, node.right);
        connect(node.right,node.next!=null ? node.next.left : null);
    }

}
