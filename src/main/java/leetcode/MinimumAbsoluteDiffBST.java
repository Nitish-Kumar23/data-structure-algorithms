package leetcode;

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 530. Minimum Absolute Difference in BST
 *
 * <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">...</a>
 *
 */
public class MinimumAbsoluteDiffBST {

    private Integer ans = Integer.MAX_VALUE;

    private Integer prev;

    public int getMinimumDifference(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        preOrder(root,sortedList);
        return minimumAbsoluteDifferenceSortedList(sortedList);
    }

    private static int minimumAbsoluteDifferenceSortedList(List<Integer> sortedList) {
        int start=0;
        int end = 1;
        int minimumDiff = Integer.MAX_VALUE;
        while(end< sortedList.size()){
            int diff = Math.abs(sortedList.get(end)- sortedList.get(start));
            if(diff<minimumDiff){
                minimumDiff = diff;
            }
            start++;
            end++;
        }
        return minimumDiff;
    }

    public void preOrder(TreeNode root, List<Integer> sortedList) {
        if(root==null){
            return;
        }
        preOrder(root.left,sortedList);
        sortedList.add(root.val);
        preOrder(root.right,sortedList);
    }

    public int getMinimumDifferenceV1(TreeNode root) {
        preOrder(root);
        return ans;
    }

    public void preOrder(TreeNode root) {
        if(root==null){
            return;
        }
        preOrder(root.left);
        if(prev!=null){
            ans = Math.min(ans,Math.abs(root.val-prev));
        }
        prev = root.val;
        preOrder(root.right);
    }

}
