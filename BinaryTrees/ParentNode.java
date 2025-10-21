package BinaryTrees;
import java.util.*;

public class ParentNode {
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

    private static void markParents(Node root, HashMap<Node, Node> parentTrack) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.left != null) {
                parentTrack.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null) {
                parentTrack.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public static List<Integer> distanceK(Node root, Node target, int k) {
        HashMap<Node, Node> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(target);
        visited.put(target, true);
        int currLevel = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            if(currLevel == k) break;
            currLevel++;

            for(int i = 0; i < size; i++) {
                Node current = queue.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null) {
                    queue.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            res.add(curr.data);
        }

        return res;
    }

    private static int maxTime(HashMap<Node, Node> map, Node target) {
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        HashMap<Node, Integer> vis = new HashMap<>();
        vis.put(target, 0);
        int maxi = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean fl = false;

            for(int i = 0; i < size; i++) {
                Node curr = q.poll();
                if(curr.left != null && vis.get(curr.left) == null) {
                    fl = true;
                    vis.put(curr.left, 1);
                    q.offer(curr.left);
                }
                if(curr.right != null && vis.get(curr.right) == null) {
                    fl = true;
                    vis.put(curr.right, 1);
                    q.offer(curr.right);
                }
                if(map.get(curr) != null && vis.get(map.get(curr)) == null) {
                    fl = true;
                    vis.put(map.get(curr), 1);
                    q.offer(map.get(curr));
                }
            }
            if(fl) maxi++;

        }
        return maxi;
    }

    public static int timeToBurn(Node root, Node start) {
        HashMap<Node, Node> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        int maxi = maxTime(parentTrack, start);
        return maxi;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(7);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(8);

        System.out.println(distanceK(root, root.left, 3));
    }
}
