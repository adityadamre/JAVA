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

    public static ArrayList<Integer> postorderIterative1(Node root) {    // Also using a single stack, (special mention to Claude BHAU)
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
    
    public static void KlevelRec(Node root, int level, int k) {
        if(root == null) return;

        if(level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KlevelRec(root.left, level + 1, k);
        KlevelRec(root.right, level + 1, k);
    }

    public static void KlevelItr(Node root, int k) {
        Queue<Node> q = new LinkedList<>();
        if(root == null) return;

        int level = 1;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node curr = q.remove();

            if(curr == null) {
                if(q.isEmpty()) {
                    return;
                } else {
                    level++;
                    q.add(null);
                }
            } else {
                if(level == k) System.out.print(curr.data + " ");

                if(curr.left != null) q.add(curr.left);

                if(curr.right != null) q.add(curr.right);
            }
        }
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

    public static int lca1(Node root, int n1, int n2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        path1 = findPath(root, n1);
        path2 = findPath(root, n2);

        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) break;
        }

        return path1.get(i - 1);
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) return root;

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(leftLca == null) return rightLca;

        if(rightLca == null) return leftLca;

        return root;
    }

    public static int lcaDist(Node root, int target) {
        if(root == null) return -1;

        if(root.data == target) return 0;

        int leftDist = lcaDist(root.left, target);
        int rightDist = lcaDist(root.right, target);

        if(leftDist == -1  && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }
    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int KthAncestor(Node root, int n, int k) {
        if(root == null) return -1;

        if(root.data == n) return 0;

        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1) return -1;

        int max = Math.max(leftDist, rightDist);
        if(max + 1 == k) {
            System.out.println(root.data);    // Output
        }

        return max + 1;
    }

    public static int helper(Node root) {
        if(root == null) return 0;

        int data = root.data;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        root.data = leftSum + rightSum;

        return data + root.data;
    }

    public static void sumTree(Node root) {
        if(root == null) return;
        helper(root);
        levelorder(root);
    }

    public static int maxPathSum(Node root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        ans[0] = maxPath(root, ans);
        return ans[0];
    }

    public static int maxPath(Node root, int[] ans) {
        if(root == null) return 0;

        int leftSum = Math.max(0, maxPath(root.left, ans));
        int rightSum = Math.max(0, maxPath(root.right, ans));

        ans[0] = Math.max(ans[0], leftSum + rightSum + root.data);

        return Math.max(leftSum, rightSum) + root.data;
    }

    static class info2 {
        Node node;
        int id;

        info2(Node node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public static int widthOfBinaryTree(Node root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<info2> q = new LinkedList<>();
        q.offer(new info2(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().id;
            int first = 0, last = 0;

            for(int i = 0; i < size; i++) {
                int currId = q.peek().id - min;
                Node node = q.peek().node;
                q.poll();
                if(i == 0) first = currId;
                if(i == size-1) last = currId;

                if(node.left != null) {
                    q.offer(new info2(node.left, (2*currId) + 1));
                }
                if(node.right != null) {
                    q.offer(new info2(node.right, (2*currId) + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    private static void markParents(Node root, Map<Node, Node> parentTrack, Node target) {
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
        Map<Node, Node> parentTrack = new HashMap<>();
        markParents(root, parentTrack, target);
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

    private static int heightLeft(Node root) {
        Node curr = root;
        int height = 0;

        while(curr != null) {
            curr = curr.left;
            height++;
        }

        return height;
    }
    private static int heightRight(Node root) {
        Node curr = root;
        int height = 0;

        while(curr != null) {
            curr = curr.right;
            height++;
        }

        return height;
    }
    public static int countNodesBT(Node root) {
        if(root == null) return 0;

        int lh = heightLeft(root);
        int rh = heightRight(root);

        if(lh == rh) return (1<<lh) - 1;

        return (1 + countNodesBT(root.left) + countNodesBT(root.right));
    }

    public static void childrenSum(Node root) {  // GFG :- parent node must be equal to sum of its child (Leaf nodes don't have any restrictions)
        if(root == null) return;

        int child = 0;
        if(root.left != null) child += root.left.data;
        if(root.right != null) child += root.right.data;

        if(child > root.data) root.data = child;
        else {
            if(root.left !=null) root.left.data = root.data;
            if(root.right !=null) root.right.data = root.data;
        }

        childrenSum(root.left);
        childrenSum(root.right);

        int total = 0;
        if(root.left != null) total += root.left.data;
        if(root.right != null) total += root.right.data;
        if(root.left != null || root.right != null) root.data = total;
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

        // ArrayList<Integer> list = postorderIterative1(root);
        // System.out.println(list);
        
        // bottomView(root);

        // System.out.println(findPath(root, 6));

        // KlevelItr(root, 3);

        // System.out.println(lca1(root, 5, 6));

        // System.out.println(minDist(root, 4, 5));

        // KthAncestor(root, 6, 1);

        // sumTree(root);

        // System.out.println(maxPathSum(root));

        // System.out.println(distanceK(root, root, 2));

        // System.out.println(countNodesBT(root));  // I/P must be a complete BT

        childrenSum(root);
        levelorder(root);

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