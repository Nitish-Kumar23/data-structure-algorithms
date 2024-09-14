package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveDuplicatesSortedLinkedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            boolean deleteNode = false;

            while (next != null && current.val == next.val) {
                deleteNode = true;
                next = next.next;
            }

            if (deleteNode) {
                prev.next = next;
            } else {
                prev = current;
            }
            current = next;
        }

        return dummy.next;
    }

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
}