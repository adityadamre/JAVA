package TwoPntr_SlidingWindow;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxOfMin {
    private static int[] NSE(int[] arr) {
        int n = arr.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] nse = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            
            st.push(i);
        }
        
        return nse;
    }
    
    private static int[] PSE(int[] arr) {
        int n = arr.length;
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] pse = new int[n];
        
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            
            st.push(i);
        }
        
        return pse;
    }
    
    public static ArrayList<Integer> maxOfMins(int[] arr) {
        int n = arr.length;
        int[] nse = NSE(arr);
        int[] pse = PSE(arr);
        
        int[] ans = new int[n + 1];
        for(int i = 0; i < n; i++) {
            int len = nse[i] - pse[i] - 1;
            ans[len] = Math.max(ans[len], arr[i]);
        }
        
        for(int i = n - 1; i >= 1; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            res.add(ans[i]);
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 50, 10, 70, 30 };

        System.out.println(maxOfMins(arr));
    }
}
