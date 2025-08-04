import java.util.*;

public class Main {
//     public static void quickSort(int[] arr, int low, int high) {
//         if(low >= high) return;
//         int mid = partition(arr, low, high);
//         quickSort(arr, low, mid - 1);
//         quickSort(arr, mid + 1, high);
//     }

//     public static int partition(int[] arr, int low, int high) {
//         int pivot = low;
//         int i = low+1;
//         int j = high;

//         while(i <= j) {
//             while(i <= j && arr[i] < arr[pivot]) i++;

//             while(i <= j && arr[j] > arr[pivot]) j--;

//             if(i < j) {
//                 int temp = arr[j];
//                 arr[j] = arr[i];
//                 arr[i] = temp;
//             }
//         }
//         int temp = arr[j];
//         arr[j] = arr[pivot];
//         arr[pivot] = temp;

//         return j;
//     }

//     public static void merge(int[] arr, int low, int mid, int high) {
//         int temp[] = new int[high - low + 1];
//         int i = low, j = mid+1, k = 0;

//         while(i <= mid && j <= high) {
//             if(arr[i] <= arr[j]) {
//                 temp[k++] = arr[i++];
//             } else {
//                 temp[k++] = arr[j++];
//             }
//         }

//         while(i <= mid) temp[k++] = arr[i++];

//         while(j <= high) temp[k++] = arr[j++];

//         for(k = 0, i = low; k < temp.length; k++, i++) arr[i] = temp[k];
//     }

//     public static void mergeSort(int[] arr, int low, int high) {
//         if(low >= high) return;

//         int mid = low + (high - low) / 2;
//         mergeSort(arr, low, mid);
//         mergeSort(arr, mid+1, high);
//         merge(arr, low, mid, high);
//     }

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
    
    public static ArrayList<Integer> preorder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        Stack<Node> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            Node curr = st.pop();
            arr.add(curr.data);

            if(curr.right != null) {
                st.push(curr.right);
            }
            if(curr.left != null) {
                st.push(curr.left);
            }
        }

        return arr;
    }

    public static ArrayList<Integer> inorder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        Stack<Node> st = new Stack<>();
        Node temp = root;

        while(true) {
            if(temp != null) {
                st.push(temp);
                temp = temp.left;
            } else {
                if(st.isEmpty()) break;
                temp = st.pop();
                arr.add(temp.data);
                temp = temp.right;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        System.out.println(inorder(root));
    }
}
