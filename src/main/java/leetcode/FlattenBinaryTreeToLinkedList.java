package leetcode;

import baseclass.TreeNode;
import binarytree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

    private BinarySearchTree.Node<Integer> head = null;

    private BinarySearchTree.Node<Integer> temp = null;

    public void flatten(BinarySearchTree.Node<Integer> root){
        flatten(root,true);
        root.setRight(head.getRight());
    }

    public void flatten(BinarySearchTree.Node<Integer> root,Boolean check){
        if(root==null){
            return;
        }
        if(head==null){
            head = new BinarySearchTree.Node<>(root.getData());
            temp = head;
        }else{
            temp.setRight(new BinarySearchTree.Node<>(root.getData()));
            temp = temp.getRight();
        }
        flatten(root.getLeft(),true);
        flatten(root.getRight(),true);
    }

    public void flattenViaQueue(BinarySearchTree.Node<Integer> root){
        Queue<BinarySearchTree.Node<Integer>> queue = new LinkedList<>();
        flattenViaQueue(root,queue);
        BinarySearchTree.Node<Integer> headNode = new BinarySearchTree.Node<>(queue.poll().getData());
        BinarySearchTree.Node<Integer> temp = headNode;
        while (!queue.isEmpty()){
            temp.setRight(queue.poll());
            temp = temp.getRight();
        }
        root.setRight(head.getRight());
        root.setLeft(null);
    }

    private void flattenViaQueue(BinarySearchTree.Node<Integer> root, Queue<BinarySearchTree.Node<Integer>> queue) {
        if(root==null){
            return;
        }
        queue.add(new BinarySearchTree.Node<>(root.getData()));
        flattenViaQueue(root.getLeft(),queue);
        flattenViaQueue(root.getRight(),queue);
    }

    public void flatten(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode current = root;
        while(current!=null){
            if(current.left!=null){
                TreeNode temp = current.left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

}
