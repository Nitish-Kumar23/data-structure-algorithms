package leetcode;

import baseclass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {

    public static class NodeParent{
        public TreeNode currentNode;
        public TreeNode parent;
        public int level;

        public NodeParent(TreeNode currentNode, TreeNode parent, int level){
            this.currentNode = currentNode;
            this.parent = parent;
            this.level = level;
        }

    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y){
            return false;
        }
        Queue<NodeParent> queue = new LinkedList<>();
        int level = 0;
        queue.add(new NodeParent(root,null,level));
        NodeParent xValResult = null;
        NodeParent yValResult = null;

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            level++;
            for (int i=0;i<levelSize;i++){
                NodeParent node = queue.poll();
                if(x==node.currentNode.val){
                    xValResult = node;
                }
                if(y==node.currentNode.val){
                    yValResult = node;
                }
                if(xValResult!=null && yValResult!=null){
                    break;
                }

                if(node.currentNode.left!=null){
                    queue.add(new NodeParent(node.currentNode.left,node.currentNode,level));
                }
                if(node.currentNode.right!=null){
                    queue.add(new NodeParent(node.currentNode.right,node.currentNode,level));
                }

            }
            if(xValResult!=null && yValResult!=null){
                break;
            }
        }
        if(xValResult==null || yValResult==null){
            return false;
        }
        if(xValResult.level==yValResult.level && xValResult.parent!=yValResult.parent){
            return true;
        }
        return false;
    }

}
