package BinaryTrees;
import java.util.*;

public class ConstructUniqueBT {
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

    public static Node buildTree1(int[] preOrder, int[] inOrder) {
        if(preOrder.length != inOrder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        Node root = preNin(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, map);

        return root;
    }

    private static Node preNin(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preOrder[preStart]);

        int inRoot = map.get(preOrder[preStart]);
        int numsLeft = inRoot - inStart;

        root.left = preNin(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, inRoot - 1, map);
        root.right = preNin(preOrder, preStart + numsLeft + 1, preEnd, inOrder, inRoot + 1, inEnd, map);

        return root;
    }

    public static Node buildTree2(int[] postOrder, int[] inOrder) {
        if(postOrder.length != inOrder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }

        Node root = postNin(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1, map);

        return root;
    }

    private static Node postNin(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(postStart > postEnd || inStart > inEnd) return null;

        Node root = new Node(postOrder[postEnd]);

        int inRoot = map.get(postOrder[postEnd]);
        int numsLeft = inRoot - inStart;

        root.left = postNin(postOrder, postStart, postStart + numsLeft - 1, inOrder, inStart, inRoot - 1, map);
        root.right = postNin(postOrder, postStart + numsLeft, postEnd - 1, inOrder, inRoot + 1, inEnd, map);

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

    public static void main(String[] args) {
        int[] inOrder = {40, 20, 50, 10, 60, 30};
        int[] preOrder = {10, 20, 40, 50, 30, 60};
        int[] postOrder = {40, 50, 20, 60, 30, 10};

        Node root1 = buildTree1(preOrder, inOrder);
        levelorder(root1);

        System.out.println();

        Node root2 = buildTree2(postOrder, inOrder);
        levelorder(root2);
    }
}
