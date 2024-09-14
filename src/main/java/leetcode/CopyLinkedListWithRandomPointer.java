package leetcode;
import java.util.HashMap;
import java.util.Map;

class CopyLinkedListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }

        // define variables for old and newly created linked list to track the list
        Map<Node,Node> oldVsNewNodeMap = new HashMap<>();
        Node temp = head;

        // create nodes for the new linked list and populate old vs new node map
        while(temp!=null){
            Node node = new Node(temp.val);
            oldVsNewNodeMap.put(temp,node);
            temp = temp.next;
        }

        // iterate and assign next and random pointers
        temp = head;
        while(temp!=null){
            Node newNode = oldVsNewNodeMap.get(temp);
            newNode.next = oldVsNewNodeMap.get(temp.next);
            newNode.random = oldVsNewNodeMap.get(temp.random);
            temp = temp.next;
        }
        return oldVsNewNodeMap.get(head);
    }
}