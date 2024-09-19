package models;

import java.util.Scanner;

public class BinaryTreeImpl {

    public void populate(Scanner scanner){
        System.out.println("Enter root node");
        TreeNode root = new TreeNode(scanner.nextInt());
        populate(scanner,root);
    }

    public TreeNode populate(Scanner scanner, TreeNode node){
        System.out.println("DO YOU WANT TO ENTER VALUE TO THE LEFT OF NODE " + node.val);
        boolean leftBoolean = scanner.nextBoolean();
        if(leftBoolean) {
            System.out.println("Enter the value left of node " + node.val);
            int value = scanner.nextInt();
            node.left = new TreeNode(value);
            node.left = populate(scanner,node.left);
        }

        System.out.println("DO YOU WANT TO ENTER VALUE TO THE RIGHT OF NODE " + node.val);
        boolean rightBoolean = scanner.nextBoolean();
        if(rightBoolean) {
            System.out.println("Enter the value  right of node " + node.val);
            int value = scanner.nextInt();
            node.right = new TreeNode(value);
            node.right = populate(scanner,node.right);
        }

        return node;
    }

    /**
     private TreeNode build() {
     String res = getStringInputFromUser();
     if(!res.equalsIgnoreCase("Y")){
     return null;
     }
     int val = getIntegerInputFromUser();
     TreeNode root = new TreeNode(val);
     System.out.println("DO YOU WANT TO ENTER VALUE TO THE LEFT OF NODE " + root.val + " Y/N");
     root.left = build();
     System.out.println("DO YOU WANT TO ENTER VALUE TO THE RIGHT OF NODE " + root.val + " Y/N");
     root.right = build();
     return root;
     }

    private Integer getIntegerInputFromUser() {
        System.out.println("Enter any number ");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        return myObj.nextInt();
    }

    private String getStringInputFromUser() {
        System.out.println("Enter string input ");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        return myObj.next();
    }

     **/

    public static void main(String[] args){
        BinaryTreeImpl tree = new BinaryTreeImpl();
        tree.populate(new Scanner(System.in));
    }

}
