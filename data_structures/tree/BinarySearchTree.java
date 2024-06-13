package data_structures.tree;

public class BinarySearchTree {

    private TreeNode<Integer> root;

    public void addValue(int value) {
        root = addValue(root, value);
    }

    // Recursive Method
    public TreeNode<Integer> addValue(TreeNode<Integer> root, int value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return root;
        }

        if (value > root.value) {
            root.right = addValue(root.right, value);
        } else {
            root.left = addValue(root.left, value);
        }

        return root;
    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printInOrder(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.value + " ");
        printInOrder(root.right);
    }

    public boolean isFound(int value) {
        return isFound(root, value);
    }

    // Recursive Method
    public boolean isFound(TreeNode<Integer> root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        } else {
            if (value < root.value) {
                return isFound(root.left, value);
            } else {
                return isFound(root.right, value);
            }
        }
    }

    public TreeNode<Integer> getNode(int value) {
        return getNode(root, value);
    }

    // Recursive Method
    public TreeNode<Integer> getNode(TreeNode<Integer> root, int value) {
        if (root == null || value == root.value) {
            return root;
        }

        if (value < root.value) {
            return getNode(root.left, value);
        } else {
            return getNode(root.right, value);
        }
    }

    // Recursive Method
    public static boolean isValid(TreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.value <= min || root.value >= max) {
            return false;
        }

        boolean left = isValid(root.left, min, root.value);
        if (left) {
            return isValid(root.right, root.value, max);
        }

        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.addValue(5);
        bst.addValue(6);
        bst.addValue(4);
        bst.addValue(1);
        bst.addValue(2);

        bst.printInOrder();
        System.out.println("\n");

        System.out.println(bst.isFound(1));

        System.out.println(bst.getNode(1).value);
    
        System.out.println(isValid(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
