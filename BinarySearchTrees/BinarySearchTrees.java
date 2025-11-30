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

    public static void preOrder(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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

    public static Node mirror(Node root) {
        if(root == null) return null;

        Node leftS = root.left;

        root.left = mirror(root.right);
        root.right = mirror(leftS);

        return root;
    }

    public static Node balanceBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end) return null;

        int mid = st + (end - st) / 2;
        Node root = new Node(arr.get(mid));
        root.left = balanceBST(arr, st, mid - 1);
        root.right = balanceBST(arr, mid + 1, end);

        return root;
    }

    private static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) return;

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node convertBalanceBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        root = balanceBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    static class info {
        boolean isBST;
        int size;
        int min;
        int max;

        info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;
    public static info largestBST(Node root) {  // root node of largest BST can also be return by twisting a bit
        if(root == null) {
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        info leftInfo = largestBST(root.left);
        info rightInfo = largestBST(root.right);

        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new info(true, size, min, max);
        }

        return new info(false, size, min, max);
    }

    
    public static Node mergeBSTs(Node root1, Node root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0, j = 0;

        while(i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i++));
            } else {
                finalArr.add(arr2.get(j++));
            }
        }
        while(i < arr1.size()) {
            finalArr.add(arr1.get(i++));
        }
        while(j < arr2.size()) {
            finalArr.add(arr2.get(j++));
        }

        Node root = balanceBST(finalArr, 0, finalArr.size() - 1);
        return root;
    }

    public static int KthSmallest(Node root, int k) {
        Stack<Node> st = new Stack<>();
        int count = 0;

        while(root != null || !st.isEmpty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            count++;
            if(count == k) return root.data;

            root = root.right;
        }

        return -1;
    }

    public static Node inorderSuccessor(Node root, Node target) {
        if (target.right != null) {
            Node curr = target.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        
        Node successor = null;
        while(root != null) {
            if(root.data > target.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return successor;
    }

    public static Node inorderPredecessor(Node root, Node target) {
        if (target.left != null) {
            Node curr = target.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            return curr;
        }

        Node predecessor = null;
        while(root != null) {
            if(root.data < target.data) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return predecessor;
    }

    static class Pair {
        int incl, excl;

        public Pair(int i, int e) {
            incl = i;
            excl = e;
        }
    }

    private static Pair helper(Node root) {
        if(root == null) return new Pair(0, 0);

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int incl = left.excl + right.excl + root.data;

        int excl = Math.max(left.incl, left.excl) + Math.max(right.incl, right.excl);

        return new Pair(incl, excl);
    }

    public static int houseRobber(Node root) {
        Pair res = helper(root);

        return Math.max(res.incl, res.excl);
    }

    public static Node greaterSumTree(Node root) {
        if(root == null || (root.left == null && root.right == null)) return root;

        Stack<Node> st = new Stack<>();
        Node temp = root;
        int sum = 0;

        while(true) {
            if(temp != null) {
                st.push(temp);
                temp = temp.right;
            } else {
                if(st.isEmpty()) break;
                temp = st.pop();
                sum += temp.data;
                temp.data = sum;
                temp = temp.left;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        // int[] arr = {5, 3, 8, 10, 4, 2, 6, 7, 1, 9};
        // Node root = null;

        // for(int i = 0; i < arr.length; i++) {
        //     root = insert(root, arr[i]);
        // }

        // inOrder(root);
        // System.out.println();

        // if(search(root, 8)) System.out.println("Found");
        // else System.out.println("Not found");

        // root = delete(root, 8);
        // inOrder(root);
        // System.out.println();

        // printInRange(root, 4, 8);
        // System.out.println();

        // root2LeafPath(root, new ArrayList<>());

        // System.out.println(isValidBST(root, null, null));

        // mirror(root);
        // inOrder(root);
        // System.out.println();

        
        // int[] temp = {8, 6, 10, 5, 11, 3, 12};
        // Node root1 = null;
        // for(int i = 0; i < temp.length; i++) {
        //     root1 = insert(root1, temp[i]);
        // }

        // preOrder(root1);
        // System.out.println();

        // root1 = convertBalanceBST(root1);
        // preOrder(root1);
        // System.out.println();


        // Node root2 = new Node(50);
        // root2.left = new Node(30);
        // root2.left.left = new Node(5);
        // root2.left.right = new Node(20);

        // root2.right = new Node(60);
        // root2.right.left = new Node(45);
        // root2.right.right = new Node(70);
        // root2.right.right.left = new Node(65);
        // root2.right.right.right = new Node(80);

        // info res = largestBST(root2);
        // System.out.println("Size of largest BST : " + maxBST);

        // Node root3 = new Node(2);
        // root3.left = new Node(1);
        // root3.right = new Node(4);

        // Node root4 = new Node(9);
        // root4.left = new Node(3);
        // root4.right = new Node(12);

        // Node root5 = mergeBSTs(root3, root4);
        // preOrder(root5);

        // System.out.println(KthSmallest(root, 10));

        // System.out.println(houseRobber(root2));

        // Node root6 = greaterSumTree(root2);
        // inOrder(root6);
    }
}
