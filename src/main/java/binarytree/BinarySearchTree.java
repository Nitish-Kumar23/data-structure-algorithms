package binarytree;

import leetcode.BinaryTreeLevelOrderTraversalII;
import leetcode.FlattenBinaryTreeToLinkedList;
import leetcode.ZigZagLevelOrderTraversal;

public class BinarySearchTree <T extends  Comparable<T>> {

    // Track number of nodes in  the BST
    private int nodeCount = 0;

    // Track root node
    private Node<T> root = null;

    // Internal class to represent node of the BST and add actual data in it
    public static class Node<T extends Comparable<T>>{
        private T data;

        private Node<T> left;

        private Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }
    }

    /**
     * check if binary tree is empty
     *
     * @return boolean
     *
     */
    public boolean isEmpty(){
        return nodeCount==0;
    }

    /**
     * returns number of nodes present in a binary tree
     *
     * @return
     */
    public Integer size(){
        return nodeCount;
    }

    /**
     * add element to the binary search tree
     *
     * @param element
     * @return
     */
    public boolean add(T element){
        if(contains(root,element)){
            return false;
        }
        else {
            add(root, element);
            nodeCount++;
            return true;
        }
    }

    /**
     *              3
     *          1        50
     *       -2      10      100
     */
    /**
     * Internal method reference to recursively add nodes in a BST
     *
     * @param node
     * @param element
     * @return
     */
    private Node<T> add(Node<T> node, T element) {  //5
        if(node==null){
            node = new Node<>(element);
            return node;
        }

        int cmp = element.compareTo(node.data);
        if(cmp<0){
            node.left = add(node.left,element);
        }else {
            node.right = add(node.right,element);
        }
        return node;
    }

    private boolean contains(Node<T> root, T element) {
        if(root==null){
            return false;
        }
        int cmp = element.compareTo(root.data);
        if(cmp==0){
            return true;
        } else if(cmp<0){
            return contains(root.left,element);
        }else {
            return contains(root.right,element);
        }
    }

    /**
     * Remove element from the binary search tree
     *
     * @param element
     * @return
     */
    public boolean remove(T element){
        if(isEmpty()){
            return false;
        }
        if(contains(root,element)){
            remove(root,element);
            nodeCount--;
            return true;
        }
        return false;
    }

    /**
     *              3
     *           0        50
     *       -2     10      100
     *           0
     */
    // Internal method to recursively remove element from the BST if it exists
    private Node<T> remove(Node<T> node, T element) {
        int cmp = element.compareTo(node.data);
        if(cmp<0){
            node.left = remove(node.left,element);
        }else if(cmp>0) {
            node.right = remove(node.right,element);
        }else {
            if(node.left==null){
                Node<T> rightNode = node.right;
                node = null;
                return rightNode;
            }else if(node.right==null){
                Node<T> leftNode = node.left;
                node = null;
                return leftNode;
            }else {
                // if both nodes are present then either return largest node of left subtree or smallest node of right subtree

                // returning largest node of left subtree
                Node<T> leftLargest = digRight(node.left);
                node.data = leftLargest.data;

                // traverse left subtree and remove node data which we swapped, we don't have duplicate in the tree
                node.left = remove(node.left,node.data);
                return node;

//                returning smallest node of right subtree
//                Node<T> rightLargest = digLeft(root.right);
//                node.data = rightLargest.data;
//
//                traverse right subtree and remove node data which we swapped, we don't have duplicate in the tree
//                node.right = remove(node.right,node.data);
//                return rightLargest;
            }
        }

        return node;
    }

    /**
     * Return right most node of the binary tree
     *
     * @param node
     * @return
     */
    private Node<T> digRight(Node<T> node) {
        while (node.right!=null){
            node = node.right;
        }
        return node;
    }

    /**
     * Return left most node of the binary tree
     * @param node
     * @return
     */
    private Node<T> digLeft(Node<T> node) {
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }

    /**
     * Pre order traversal for binary tree
     *
     * @param node
     */
    private void preOrderTraversal(Node<T> node){
        if(node==null){
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     *              5
     *           3       7
     *        1       6      8
     *     -2                      9
     *
     * @param args
     */
    public static void main(String[] args){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.root = new Node<>(5);
        binarySearchTree.nodeCount++;
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        binarySearchTree.add(-2);
        binarySearchTree.add(7);
        binarySearchTree.add(8);
        binarySearchTree.add(6);
        binarySearchTree.add(9);
        binarySearchTree.preOrderTraversal(binarySearchTree.root);

        // verifying level order traversal logic here
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrderTraversal(binarySearchTree.root);

        // zig zag traversal logic here
        ZigZagLevelOrderTraversal zigZagLevelOrderTraversal = new ZigZagLevelOrderTraversal();
        zigZagLevelOrderTraversal.zigzagLevelOrder(binarySearchTree.root);

        // level order traversal
        BinaryTreeLevelOrderTraversalII binaryTreeLevelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        binaryTreeLevelOrderTraversalII.levelOrderBottom(binarySearchTree.root);

        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        flattenBinaryTreeToLinkedList.flatten(binarySearchTree.root);

        System.out.println();
        binarySearchTree.remove(-2);
        binarySearchTree.preOrderTraversal(binarySearchTree.root);
        System.out.println();
        binarySearchTree.remove(7);
        binarySearchTree.preOrderTraversal(binarySearchTree.root);
        System.out.println();
        binarySearchTree.remove(9);
        binarySearchTree.preOrderTraversal(binarySearchTree.root);
    }

}
