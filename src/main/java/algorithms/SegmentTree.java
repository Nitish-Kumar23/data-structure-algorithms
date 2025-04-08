package algorithms;

/**
 * Segment tree
 */
public class SegmentTree {

    private final Node root;

    // Constructor to build the segment tree from the given array
    public SegmentTree(int[] arr) {
        this.root = segmentTree(arr);
    }

    // This method initializes the segment tree
    private Node segmentTree(int[] arr) {
        return constructSegmentTree(arr, 0, arr.length - 1);
    }

    // This method recursively constructs the segment tree
    private Node constructSegmentTree(int[] arr, int start, int end) {
        // Base condition for invalid range
        if (start < 0 || end < 0 || start > end) {
            return null;
        }

        // If the range represents a single element, create a leaf node
        if (start == end) {
            return new Node(arr[start], start, end);
        }

        // Recursive case: split the range into two halves
        int mid = (start + end) / 2;
        Node left = constructSegmentTree(arr, start, mid); // Left subtree
        Node right = constructSegmentTree(arr, mid + 1, end); // Right subtree

        // Create a new node with the sum of the left and right subtrees
        return new Node(left.data + right.data, start, end, left, right);
    }

    // Main method to test the segment tree
    public static void main(String[] args) {
        SegmentTree segmentTree = new SegmentTree(new int[]{3, 8, 7, 6, -2, -8, 4, 9});

        // Querying the sum from index 2 to 6
        System.out.println(segmentTree.findSumInRange(2, 6));

        // Querying the sum from index 0 to 8
        System.out.println(segmentTree.findSumInRange(0, 8));

        // Updating index 2 with value 15
        segmentTree.updateIndex(2, 15);

        // Querying the sum from index 2 to 6 after update
        System.out.println(segmentTree.findSumInRange(2, 6));

        // Updating index 5 with value 19
        segmentTree.updateIndex(5, 19);
    }

    // Method to find the sum in the specified range
    private Integer findSumInRange(int start, int end) {
        return rangeSum(root, start, end);
    }

    // Recursive helper method to calculate the sum of a given range
    private Integer rangeSum(Node node, int start, int end) {
        // If the node is null or if it's outside the range, return 0
        if (node == null || isOutsideRange(start, end, node)) {
            return 0;
        }

        // If the node is completely within the range, return its data
        if (isInsideRangeInterval(start, end, node)) {
            return node.data;
        }

        // Otherwise, calculate the sum of the left and right child nodes
        Integer left = rangeSum(node.left, start, end);
        Integer right = rangeSum(node.right, start, end);

        // Return the sum of both sides
        return left + right;
    }

    // Method to update the value at the given index
    private void updateIndex(int index, int value) {
        updateIndex(root, index, value);
    }

    // Recursive helper method to update the index in the segment tree
    private int updateIndex(Node node, int index, int value) {
        // If the node is a leaf node and matches the index, update the value
        if (node.start == node.end && node.start == index) {
            node.data = value;
            return node.data;
        }

        // If the index is outside the node's range, do not update it
        if (isIndexOutsideRange(node, index)) {
            return node.data;
        }

        // Update the left and right subtrees recursively
        int left = updateIndex(node.left, index, value);
        int right = updateIndex(node.right, index, value);

        // After updating, re-calculate the node's value
        node.data = left + right;

        return node.data;
    }

    // Helper method to check if the index is outside the node's range
    private boolean isIndexOutsideRange(Node node, int index) {
        return node.end < index || node.start > index;
    }

    // Helper method to check if the node's range is completely inside the query range
    private boolean isInsideRangeInterval(int start, int end, Node node) {
        return node.start >= start && node.end <= end;
    }

    // Helper method to check if the node's range is completely outside the query range
    private boolean isOutsideRange(int start, int end, Node node) {
        return node.start > end || node.end < start;
    }

    // Nested Node class representing each segment of the tree
    private static class Node {
        int data; // Sum of the segment
        int start; // Start index of the segment
        int end; // End index of the segment
        Node left; // Left child node
        Node right; // Right child node

        // Constructor for a leaf node
        public Node(int data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        // Constructor for a non-leaf node with left and right children
        public Node(int data, int start, int end, Node left, Node right) {
            this.data = data;
            this.start = start;
            this.end = end;
            this.left = left;
            this.right = right;
        }
    }
}