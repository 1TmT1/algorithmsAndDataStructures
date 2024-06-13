package data_structures.tree;

import java.util.Deque;
import java.util.LinkedList; 

public class BinaryTree {

    private TreeNode<Integer> root;

    public BinaryTree() {
        root = null;
    }

    public void setRoot(TreeNode<Integer> newRoot) {
        root = newRoot;
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }

    // Recursive Method
    public static void printPreOrderTraversal(TreeNode<Integer> root) {
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

        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<Integer> temp = stack.pop();
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
    public static void printInOrderTraversal(TreeNode<Integer> root) {
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

        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> temp = root;

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
    public static void printPostOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    // Iterative Method
    public void printPostOrderTraversal() {
        Deque<TreeNode<Integer>> stack = new LinkedList<>();
        TreeNode<Integer> temp = root;

        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                TreeNode<Integer> temp2 = stack.peek().right;
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
    // BFS = Breadth-First Traversal 
    public void printLevelOrderTraversal(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> temp = queue.poll();
            System.out.print(temp.value + " ");

            if (temp.left != null) {
                queue.offer(temp.left);
            }

            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    // Recursive Method
    public static int findMax(TreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int max = root.value;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left > max) {
            max = left;
        }

        if (right > max) {
            max = right;
        }

        return max;
    }

    public static void main(String[] args) {

        // Creation of Binary Tree
        BinaryTree binaryTree = new BinaryTree();

        TreeNode<Integer> n1 = new TreeNode<>(1);
        TreeNode<Integer> n2 = new TreeNode<>(2);
        TreeNode<Integer> n3 = new TreeNode<>(3);
        TreeNode<Integer> n4 = new TreeNode<>(4);
        TreeNode<Integer> n5 = new TreeNode<>(5);
        TreeNode<Integer> n6 = new TreeNode<>(6);
        TreeNode<Integer> n7 = new TreeNode<>(7);

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
        System.out.println("\n");

        System.out.println("Max value: " + findMax(binaryTree.root));
    
        
        System.out.println(BinarySearchTree.isValid(binaryTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
