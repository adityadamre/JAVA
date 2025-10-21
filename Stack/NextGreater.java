import java.util.*;

public class NextGreater {  // O(n)
    public static void nextGreater(int[] arr, int[] nxtGreater) {
        Stack<Integer> s = new Stack<>();

        for(int i = arr.length - 1; i > 0; i--) {
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }
        
        for(int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
    }
    
    // SIMILARLY WE CAN PERFORM : 1) nextGreaterLeft
    //                            2) nextSmallerRight
    //                            3) nextSmallerLeft
    
    public static int[] nextGreater2(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        
        for(int i = (2*n) - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i % n]) {
                st.pop();
            }
            if(i < n) {
                res[i] = st.isEmpty() ? -1 : arr[st.peek()];
            }

            st.push(i % n);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 0, 7, 1, 2};
        int[] nxtGreater = new int[arr.length];

        nextGreater(arr, nxtGreater);
        System.out.println();

        int[] res = nextGreater2(arr);
        for(int i: res) {
            System.out.print(i + " ");
        }
    }
}
