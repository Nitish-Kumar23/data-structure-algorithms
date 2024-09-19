package leetcode;

import models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessorBinaryTree {

    /**
     * Fina the level order successor in a binary tree, in a level order we need to return the node which comes sequentially next to the given element
     *
     *
     * @param root
     * @param element
     */
    public void levelOrderSuccessor(TreeNode root, Integer element) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (node.val == element) {
                break;
            }
        }

        System.out.println(queue.peek());
    }
}
