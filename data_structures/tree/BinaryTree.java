package data_structures.tree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree {

    private TreeNode root;

    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public void setRoot(TreeNode newRoot) {
        root = newRoot;
    }

    public TreeNode getRoot() {
        return root;
    }

    // Recursive Method
    public static void printPreOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }

    // Iterative Method
    public void printPreOrderTraversal() {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.value + " ");

            if (temp.right != null) {
                stack.push(temp.right);
            }

            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
    }

    // Recursive Method
    public static void printInOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrderTraversal(root.left);
        System.out.print(root.value + " ");
        printInOrderTraversal(root.right);
    }

    // Iterative Method
    public void printInOrderTraversal() {
        if (root == null) {
            return;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                System.out.print(temp.value + " ");
                temp = temp.right;
            } 
        }
    }

    // Recursive Method
    public static void printPostOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    // Iterative Method
    public void printPostOrderTraversal() {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode temp = root;

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                TreeNode temp2 = stack.peek().right;
                if (temp2 == null) {
                    temp2 = stack.poll();
                    System.out.print(temp2.value + " ");
                    while (!stack.isEmpty() && temp2 == stack.peek().right) {
                        temp2 = stack.poll();
                        System.out.print(temp2.value + " ");
                    }
                } else {
                    temp = temp2;
                }
            }
        }
    }

    // Iterative Method 
    public void printLevelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.value + " ");

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {

        // Creation of Binary Tree
        BinaryTree binaryTree = new BinaryTree();

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        binaryTree.setRoot(n1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;

        // Running the Algorithms on the Binary Tree
        System.out.println("Print tree pre order:");
        printPreOrderTraversal(binaryTree.root);
        System.out.println();
        binaryTree.printPreOrderTraversal();
        System.out.println("\n");

        System.out.println("Print tree in order:");
        printInOrderTraversal(binaryTree.root);
        System.out.println();
        binaryTree.printInOrderTraversal();
        System.out.println("\n");

        System.out.println("Print tree post order:");
        printPostOrderTraversal(binaryTree.root);
        System.out.println();
        binaryTree.printPostOrderTraversal();
        System.out.println("\n");

        System.out.println("Print tree level order:");
        binaryTree.printLevelOrderTraversal(binaryTree.root);
    }
}
