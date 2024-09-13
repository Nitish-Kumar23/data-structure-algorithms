package leetcode;

class ReverseLinkedListII {

    /**
     *
     * Definition for singly-linked list.
     *
     **/
     public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right){
            return head;
        }

        ListNode temp = head;
        int index = 1;

        ListNode leftMostNode = null;
        ListNode leftMostNodeNext = head;

        while(temp!=null && index<left){
            leftMostNode = temp;
            leftMostNodeNext = leftMostNodeNext.next;
            index++;
            temp = temp.next;
        }

        ListNode prevNode = leftMostNode;
        while(temp!=null && index<=right){
            ListNode nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
            index++;
        }
        if(leftMostNode==null){
            head = prevNode;
        }else {
            leftMostNode.next = prevNode;
        }
        leftMostNodeNext.next = temp;

        return head;

    }
}