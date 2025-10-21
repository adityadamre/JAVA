package BinaryTrees;

import java.util.*;

public class SerializeDeserializeBT {
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

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if(root == null) return "";

        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node == null) {
                res.append("* ");
            } else {
                res.append(node.data + " ");
                q.add(node.left);
                q.add(node.right);
            }
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if(data == "") return null;

        Queue<Node> q = new LinkedList<>();
        String[] str = data.split(" ");
        Node root = new Node(Integer.parseInt(str[0]));
        q.add(root);

        for(int i = 1; i < str.length; i++) {
            Node parent = q.poll();

            if(!str[i].equals("*")) {
                parent.left = new Node(Integer.parseInt(str[i]));
                q.add(parent.left);
            }
            if(!str[++i].equals("*")) {
                parent.right = new Node(Integer.parseInt(str[i]));
                q.add(parent.right);
            }
        }

        return root;
    }

    public static void levelorder(Node root) {
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();

            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        String str = new String("1 2 3 * 4 5 * * * * 6 * * ");
        // Both are equivalent
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right = new Node(3);
        root1.right.left = new Node(5);
        root1.right.left.right = new Node(6);
        
        Node root = deserialize(str);
        inOrder(root);
        System.out.println('\n');
        
        System.out.println(serialize(root1));
    }
}
