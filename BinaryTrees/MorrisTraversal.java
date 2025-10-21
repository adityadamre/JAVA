package BinaryTrees;

import java.util.*;

public class MorrisTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<Integer> getInorder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        Node curr = root;

        while(curr != null) {
            if(curr.left == null) {
                inorder.add(curr.data);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while(prev.right != curr && prev.right != null) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorder.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return inorder;
    }

    public static ArrayList<Integer> getPreorder(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Node curr = root;

        while(curr != null) {
            if(curr.left == null) {
                preorder.add(curr.data);
                curr = curr.right;
            } else {
                Node prev = curr.left;

                while(prev.right != curr && prev.right != null) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    prev.right = curr;
                    preorder.add(curr.data);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

        return preorder;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right = new Node(3);

        System.out.println(getPreorder(root));
    }
}