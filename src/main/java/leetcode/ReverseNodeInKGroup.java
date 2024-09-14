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
class ReverseNodeInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode lenNode = head;
        while (lenNode != null) {
            length++;
            lenNode = lenNode.next;
        }

        if (k > length) {
            return head;
        }

        int iteration = length / k;
        ListNode lno = head;
        ListNode rno = head;
        ListNode lne = null;
        ListNode rne = null;
        int iterationCount = 1;
        ListNode temp = head;
        ListNode prev = null;
        while (iterationCount <= iteration) {
            int index = 0;
            while (temp != null && index < k) {
                if (iterationCount % 2 != 0) {
                    if (index == 0) {
                        lno = temp;
                        prev = null;
                    }
                    rno = temp;
                }
                if (iterationCount % 2 == 0) {
                    if (index == 0) {
                        lne = temp;
                        prev = null;
                    }
                    rne = temp;
                }
                ListNode node = temp.next;
                temp.next = prev;
                prev = temp;
                temp = node;
                index++;
            }
            if (iterationCount % 2 == 0) {
                lno.next = rne;
            }
            if (iterationCount % 2 != 0) {
                if (iterationCount == 1) {
                    head = rno;
                } else if (lne != null) {
                    lne.next = rno;
                }
            }

            iterationCount++;
        }

        if (iterationCount % 2 == 0 && lno != null) {
            lno.next = temp;
        }
        if (iterationCount % 2 != 0 && lne != null) {
            lne.next = temp;
        }

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