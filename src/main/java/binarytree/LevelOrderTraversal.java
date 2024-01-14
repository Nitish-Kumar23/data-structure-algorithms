package binarytree;

import binarytree.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderTraversal {

    private List<List<Integer>> result = new ArrayList<>();

    /**
     * method to perform level order traversal and display the result
     *
     * @param node
     */
    public void levelOrderTraversal(BinarySearchTree.Node<Integer> node){
        levelOrderTraversal(node,result,0);
        printTraversal();
    }

    /**
     * Internal method for Level order traversal
     *
     * @param node
     * @param result
     * @param level
     */
    private void levelOrderTraversal(BinarySearchTree.Node<Integer> node, List<List<Integer>> result, int level) {
        if(node==null){
            return;
        }
        checkListAndAdd(node.getData(),result,level);
        level++;
        levelOrderTraversal(node.getLeft(),result,level);
        levelOrderTraversal(node.getRight(),result,level);
    }

    /**
     * Internal method performing level order traversal recursively and then add the result in array list
     *
     * @param val
     * @param result
     * @param level
     */
    private void checkListAndAdd(int val, List<List<Integer>> result,int level) {
        if(result.size()<=level){
            result.add(new ArrayList<>(Collections.singleton(val)));
            return;
        }
        List<Integer> list = result.get(level);
        list.add(val);
        result.set(level,list);
    }

    /**
     * Print traversal
     */
    private void printTraversal() {
        System.out.println();
        System.out.println("------------PRINTING LEVEL ORDER TRAVERSAL-----------------------");
        int level = 0;
        for (List<Integer> list : result){
            System.out.println("L" + level++ + ": " + list);
        }
        System.out.println("------------SUCCESSFULLY PRINTED LEVEL ORDER TRAVERSAL-----------");
    }

}
