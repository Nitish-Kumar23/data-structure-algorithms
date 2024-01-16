package leetcode;


import binarytree.BinarySearchTree;

import java.util.*;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(BinarySearchTree.Node<Integer> root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<BinarySearchTree.Node<Integer>> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean reverse = false;
        while (!deque.isEmpty()){
            int levelSize = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0;i<levelSize;i++) {
                if (!reverse) {
                    BinarySearchTree.Node<Integer> node = deque.pollFirst();
                    if(node.getLeft()!=null){
                        deque.addLast(node.getLeft());
                    }
                    if(node.getRight()!=null){
                        deque.addLast(node.getRight());
                    }
                    currentLevel.add(node.getData());
                }

                if (reverse) {
                    BinarySearchTree.Node<Integer> node = deque.pollLast();
                    if(node.getRight()!=null){
                        deque.addFirst(node.getRight());
                    }
                    if(node.getLeft()!=null){
                        deque.addFirst(node.getLeft());
                    }
                    currentLevel.add(node.getData());
                }
            }
            result.add(currentLevel);
            reverse = ! reverse;
        }
        return result;
    }

}
