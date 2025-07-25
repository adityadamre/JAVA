package BinaryTrees;
import java.util.*;

public class BinaryTrees {
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

    static class BinaryTree {
        static int idx = -1;

        public static Node Buildtree(int nodes[]) { // O(n)
            idx++;
            if(nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = Buildtree(nodes);
            newNode.right = Buildtree(nodes);

            return newNode;
        }
    }

    public static void preorder(Node root) {    // O(n)
        if(root == null) return;    // We can print -1 along with return statement

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static ArrayList<Integer> preorderItr(Node root) {
        ArrayList<Integer> preOrder = new ArrayList<>();
        if(root == null) return preOrder;
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            root = st.pop();
            preOrder.add(root.data);
            
            if(root.right != null) {
                st.push(root.right);
            }
            if(root.left != null) {
                st.push(root.left);
            }
        }

        return preOrder;
    }

    public static void inorder(Node root) {    // O(n)
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static ArrayList<Integer> inorderItr(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        if(root == null) return inOrder;
        Stack<Node> st = new Stack<>();
        Node temp = root;

        while(true) {
            if(temp != null) {
                st.push(temp);
                temp = temp.left;
            } else {
                if(st.isEmpty()) break;
                temp = st.pop();
                inOrder.add(temp.data);
                temp = temp.right;
            }
        }

        return inOrder;
    }

    public static void postorder(Node root) {   // O(n)
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static ArrayList<Integer> postorderIterative2(Node root) {  // using two stacks
        ArrayList<Integer> postOrder = new ArrayList<>();
        if(root == null) return postOrder;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);

        while(!st1.isEmpty()) {
            root = st1.pop();
            st2.add(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }
        while(!st2.isEmpty()) {
            postOrder.add(st2.pop().data);
        }

        return postOrder;
    }

    public static ArrayList<Integer> postorderIterative1(Node root) {    // Also using a single stack, (special mention to claude BHAU)
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<Node> stack = new Stack<>();
        Node lastVisited = null;
        Node current = root;
        
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                Node peekNode = stack.peek();   // Keeps track of lastvisited node & avoid revisiting right subtrees
                
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    result.add(peekNode.data);
                    lastVisited = stack.pop();
                }
            }
        }

        return result;
    }

    // public static ArrayList<Integer> postorderIterative(Node root) {  // using a single stack, (Shradhha Didi)
    //     ArrayList<Integer> postOrder = new ArrayList<>();

    //     if(root == null) return postOrder;
        
    //     Stack<Node> st = new Stack<>();
    //     Node curr = root;

    //     while(curr != null || !st.isEmpty()) {
    //         if(curr != null) {
    //             st.push(curr);
    //             curr = curr.left;
    //         } else {
    //             Node temp = st.peek().right;
    //             if(temp == null) {
    //                 temp = st.pop();
    //                 postOrder.add(temp.data);
    //                 while(!st.isEmpty() && temp == st.peek().right) {
    //                     temp = st.pop();
    //                     postOrder.add(temp.data);
    //                 }
    //             } else {
    //                 curr = temp;
    //             }
    //         }
    //     }

    //     return postOrder;
    // }

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

    public static int height(Node root) {   // Height can be calculated in terms of maximum Nodes OR Edges
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return (Math.max(lh, rh) + 1);
    }

    public static int countNodes(Node root) {
        if(root == null) return 0;

        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);

        return (leftCount + rightCount + 1);
    }

    public static int sumNodes(Node root) {
        if(root == null) return 0;

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        return (leftSum + rightSum + root.data);
    }

    public static int diameterBruteForce(Node root) {
        if(root == null) return 0;

        int leftDiam = diameterBruteForce(root.left);
        int rightDiam = diameterBruteForce(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh + rh + 1, Math.max(leftDiam, rightDiam));
    }

    static class info {
        int diam;
        int ht;

        info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static info diameter(Node root) {
        if(root == null) return new info(0, 0);

        info leftInfo = diameter(root.left);
        info rightInfo = diameter(root.right);

        int diam = Math.max(leftInfo.ht + rightInfo.ht + 1, Math.max(leftInfo.diam, rightInfo.diam));
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new info(diam, ht);
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if(root == null && subRoot == null) {
            return true;
        } else if(root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }

        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if(root == null) {
            return false;
        }

        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static class infoMap {
        int hd; // Horizontal Distance
        Node node;

        infoMap(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public static void topView(Node root) {
        Queue<infoMap> que = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        que.add(new infoMap(0, root));
        que.add(null);

        while(!que.isEmpty()) {
            infoMap curr = que.remove();

            if(curr == null) {
                if(que.isEmpty()) {
                    break;
                } else {
                    que.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)) {     // hd is occuring for the first time
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null) {
                    min = Math.min(min, curr.hd - 1);
                    que.add(new infoMap(curr.hd - 1, curr.node.left));
                }
                if(curr.node.right != null) {
                    max = Math.max(max, curr.hd + 1);
                    que.add(new infoMap(curr.hd + 1, curr.node.right));
                }
            }
        }

        for(int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void bottomView(Node root) {
        Queue<infoMap> que = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        que.add(new infoMap(0, root));
        que.add(null);

        while(!que.isEmpty()) {
            infoMap curr = que.remove();

            if(curr == null) {
                if(que.isEmpty()) {
                    break;
                } else {
                    que.add(null);
                }
            } else {
                map.put(curr.hd, curr.node);
                
                if(curr.node.left != null) {
                    min = Math.min(min, curr.hd - 1);
                    que.add(new infoMap(curr.hd - 1, curr.node.left));
                }
                if(curr.node.right != null) {
                    max = Math.max(max, curr.hd + 1);
                    que.add(new infoMap(curr.hd + 1, curr.node.right));
                }
            }
        }

        for(int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static boolean getPath(Node root, ArrayList<Integer> arr, int target) {
        if(root == null) return false;

        arr.add(root.data);

        if(root.data == target) return true;

        if(getPath(root.left, arr, target) || getPath(root.right, arr, target)) return true;

        arr.remove(arr.size() - 1);
        return false;
    }

    public static ArrayList<Integer> findPath(Node root, int target) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        getPath(root, arr, target);
        return arr;
    }

    public static void main(String[] args) {
        // int[] nodes1 = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        // BinaryTree tree1 = new BinaryTree();
        // Node root = tree1.Buildtree(nodes1);
        // System.out.println(root.data);

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        ArrayList<Integer> list = postorderIterative1(root);
        System.out.println(list);
        
        // bottomView(root);

        // System.out.println(findPath(root, 6));

        // levelorder(root);
        // System.out.println("Height : " + height(root));
        // System.out.println("Nodes : " + countNodes(root));
        // System.out.println("Sum : " + sumNodes(root));
        // System.out.println("Diameter : " + diameter(root).diam);

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);
        // System.out.println(isSubtree(root, subRoot));

        // topView(root);
    }
}