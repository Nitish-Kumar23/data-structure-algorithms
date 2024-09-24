package algopractice;

public class BSTV2<T extends Comparable<T>> {

    private int nodeCount = 0;

    private Node<T> root = null;

    public static class Node<T extends Comparable<T>>{
        private T val;
        private Node<T> left;
        private Node<T> right;

        public Node(T val) {
            this.val = val;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
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

    public boolean addRootNode(T element){
        if(root!=null){
            return false;
        }
        root = new Node<>(element);
        nodeCount++;
        return true;
    }

    public boolean add(T element){
        if(contains(root,element)){
            return false;
        }
        add(root,element);
        nodeCount++;
        return true;
    }

    private boolean contains(Node<T> node,T element){
        if(node==null){
            return false;
        }

        int cmp = element.compareTo(node.val);
        if(cmp==0){
            return true;
        } else if (cmp<0) {
            return contains(node.left,element);
        }
        return contains(node.right,element);
    }

    private Node<T> add(Node<T> node,T element){
        if(node==null){
            node = new Node<>(element);
            return node;
        }

        int cmp = element.compareTo(node.val);
        if(cmp<0){
            node.left = add(node.left,element);
        } else if (cmp>0) {
            node.right = add(node.right,element);
        }

        return node;
    }

    public boolean remove(T element){
        if(!contains(root,element)){
            return false;
        }
        remove(root,element);
        nodeCount--;
        return true;
    }

    private Node<T> remove(Node<T> node,T element){
        int cmp = element.compareTo(node.val);
        if(cmp<0){
            node.left = remove(node.left,element);
        } else if (cmp>0) {
            node.right = remove(node.right,element);
        }else {
            if(node.left==null){
                return node.right;
            } else if (node.right==null) {
                return node.left;
            }

            // largest node in left subtree
            Node<T> largestNodeLeft = digRight(node.left);
            node.val = largestNodeLeft.val;
            node.left =remove(node.left,largestNodeLeft.val);
        }

        return node;

    }

    private Node<T> digRight(Node<T> node){
        while (node.right!=null){
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        BSTV2<Integer> binarySearchTree = new BSTV2<>();
        binarySearchTree.addRootNode(10);
        binarySearchTree.add(8);
        binarySearchTree.add(6);
        binarySearchTree.add(4);
        binarySearchTree.add(4);
        binarySearchTree.add(2);
        binarySearchTree.add(5);
        binarySearchTree.add(9);
        binarySearchTree.add(15);
        binarySearchTree.add(12);
        binarySearchTree.add(19);
        binarySearchTree.add(16);
        binarySearchTree.remove(12);
        binarySearchTree.remove(19);
        binarySearchTree.remove(4);
        System.out.println("check");

    }

}
