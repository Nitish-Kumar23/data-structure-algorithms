package algopractice;

public class BST<T extends Comparable<T>> {

    private BstNode<T> root = null;

    private int nodeCount = 0;

    public static class BstNode<T extends Comparable<T>> {

        private T val;

        private BstNode<T> left;

        private BstNode<T> right;

        public BstNode(){

        }

        public BstNode(T val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public BstNode<T> getLeft() {
            return left;
        }

        public void setLeft(BstNode<T> left) {
            this.left = left;
        }

        public BstNode<T> getRight() {
            return right;
        }

        public void setRight(BstNode<T> right) {
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BST<Integer> binarySearchTree = new BST<>();
        binarySearchTree.root = new BstNode<>(10);
        System.out.println(binarySearchTree.add(8));
        System.out.println(binarySearchTree.add(9));
        System.out.println(binarySearchTree.remove(4));
    }

    private boolean remove(T element) {
        if(!contains(root,element)){
            return false;
        }
        remove(root,element);
        nodeCount--;
        return true;
    }

    private BstNode<T> remove(BstNode<T> node, T element) {
        int cmp = element.compareTo(node.val);
        if(cmp<0){
            node.left = remove(node.left,element);
        } else if (cmp>0) {
            node.right = remove(node.right,element);
        } else if (cmp == 0) {
            if(node.left==null){
                return node.right;
            } else if (node.right==null) {
                return node.left;
            }

            // find largest element of left subtree
            BstNode<T> largest = digRight(node.left);

            node.val = largest.val;
            node.left = remove(node.left,largest.val);
            return node;
        }

        return node;
    }

    private BstNode<T> digRight(BstNode<T> left) {
        BstNode<T> node = left;
        while (left!=null){
            node = left;
            left = left.right;
        }
        return node;
    }

    private boolean add(T element) {
        if(contains(root,element)){
            return false;
        }else {
            add(root, element);
            nodeCount++;
            return true;
        }
    }

    private BstNode<T> add(BstNode<T> node,T element){
        if(node==null){
            node = new BstNode<>(element);
            return node;
        }

        int cmp = element.compareTo(node.val);
        if(cmp<0){
            node.left = add(node.left,element);
        }else {
            node.right = add(node.right,element);
        }

        return node;
    }

    private boolean contains(BstNode<T> node,T element) {
        if(node==null){
            return false;
        }
        int cmp = element.compareTo(node.val);
        if(cmp==0){
            return true;
        } else if (cmp<0) {
            return contains(node.left,element);
        }else {
            return contains(node.right,element);
        }
    }

}
