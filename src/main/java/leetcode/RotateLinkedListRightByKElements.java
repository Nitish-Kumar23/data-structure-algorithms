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
class RotateLinkedListRightByKElements {

    public ListNode rotateRight(ListNode head, int k) {
        // Handling edge cases
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        // calculating length of linked list along with tail
        ListNode temp = head;
        int length = 0;
        ListNode tail = null;
        while (temp != null) {
            length++;
            tail = temp;
            temp = temp.next;
        }

        // effective number of elements to shift right
        k = k % length;
        if (k == 0) {
            return head;
        }

        // traverse the linked list updated k size
        k = length - k;

        // iterating to find new tail of the trimmed linked list
        int index = 1;
        ListNode current = head;
        while (index < k) {
            current = current.next;
            index++;
        }

        // reassinging head and tail pointers
        ListNode oldHead = head;
        head = current.next;
        current.next = null;
        tail.next = oldHead;

        return head;

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