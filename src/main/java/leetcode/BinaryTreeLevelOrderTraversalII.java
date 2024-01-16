package leetcode;

import baseclass.TreeNode;
import binarytree.BinarySearchTree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(BinarySearchTree.Node<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<BinarySearchTree.Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        Stack<List<Integer>> stack = new Stack<>();
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                BinarySearchTree.Node<Integer> node = queue.poll();
                if(node.getLeft()!=null){
                    queue.add(node.getLeft());
                }
                if(node.getRight()!=null){
                    queue.add(node.getRight());
                }
                currentLevel.add(node.getData());
            }
            stack.push(currentLevel);
        }
        result.add(0,Arrays.asList(1));

        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

}
