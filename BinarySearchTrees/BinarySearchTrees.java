package BinarySearchTrees;
import java.util.*;

public class BinarySearchTrees {
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int target) {
        if(root == null) return false;

        if(root.data == target) {
            return true;
        } else if(target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static Node delete(Node root, int target) {
        if(target < root.data) {
            root.left = delete(root.left, target);
        } else if(target > root.data) {
            root.right = delete(root.right, target);
        } else {    // "VOILA" case as Shraddha Didi call it
            // Case I : leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            // Case II : single child
            else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            // Case III : both child
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);   // This will always fall in Case I or II
        }

        return root;
    }

    private static Node inOrderSuccessor(Node root) {
        while(root.left != null) root = root.left;
        return root;
    }

    public static void printInRange(Node root, int low, int high) {
        if(root == null) return;

        if(root.data >= low && root.data <= high) {
            printInRange(root.left, low, high);
            System.out.print(root.data + " ");
            printInRange(root.right, low, high);
        } else if(root.data < low) {
            printInRange(root.right, low, high);
        } else {
            printInRange(root.left, low, high);
        }
    }

    public static void root2LeafPath(Node root, ArrayList<Integer> path) {
        if(root == null) return;

        path.add(root.data);
        if(root.left == null && root.right == null) System.out.println(path);
        root2LeafPath(root.left, path);
        root2LeafPath(root.right, path);
        path.remove(path.size() - 1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) return true;

        if(min != null && root.data <= min.data) return false;
        else if(max != null && root.data >= max.data) return false;

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 10, 4, 2, 6, 7, 1, 9};
        Node root = null;

        for(int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }

        inOrder(root);
        System.out.println();

        // if(search(root, 0)) System.out.println("Found");
        // else System.out.println("Not found");

        // root = delete(root, 8);
        // inOrder(root);
        // System.out.println();

        // printInRange(root, 4, 8);
        // System.out.println();

        // root2LeafPath(root, new ArrayList<>());

        // System.out.println(isValidBST(root, null, null));
    }
}
