package BinarySearchTrees;

public class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if(root == null) return 0;

        return root.height;
    }

    public static int getBalance(Node root) {
        if(root == null) return 0;

        return height(root.left) - height(root.right);
    }

    public static Node rightRotate(Node x) {
        Node y = x.left;
        Node T2 = y.right;

        y.right = x;
        x.left = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public static Node insert(Node root, int val) {
        if(root == null) return new Node(val);

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else if(val > root.data) {
            root.right = insert(root.right, val);
        } else {    // Duplicate element
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int bf = getBalance(root);

        if(bf < -1 && val > root.right.data) {  // Right Right Case
            return leftRotate(root);
        }
        
        if(bf < -1 && val < root.right.data) {  // Right Left Case
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        if(bf > 1 && val < root.left.data) {    // Left Left Case
            return rightRotate(root);
        }
        
        if(bf > 1 && val > root.left.data) {    // Left Right Case
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preOrder(root);
    }
}
