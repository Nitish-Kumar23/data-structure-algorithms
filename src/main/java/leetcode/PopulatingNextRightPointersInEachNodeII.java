package leetcode;/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PopulatingNextRightPointersInEachNodeII {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Node> elements = new ArrayList<>();
            while (!queue.isEmpty()) {
                elements.add(queue.poll());
            }

            for (int i = 0; i < elements.size(); i++) {
                Node element = elements.get(i);
                if (i + 1 < elements.size()) {
                    element.next = elements.get(i + 1);
                }
                if (element.left != null) {
                    queue.add(element.left);
                }
                if (element.right != null) {
                    queue.add(element.right);
                }
            }
        }

        return root;
    }

    public Node connectV2(Node root) {
        if(root==null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int index = 0;
            while(index<size){
                Node node = queue.poll();
                if(index+1<size){
                    node.next = queue.peek();
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                index++;
            }

        }

        return root;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}