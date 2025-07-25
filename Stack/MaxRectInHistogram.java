import java.util.*;

public class MaxRectInHistogram {
    public static int largestRectangleArea(int[] arr) {
        int maxArea = 0;
        int[] nextSmaller = new int[arr.length];
        int[] prevSmaller = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        // NEXT SMALLER
        for(int i = arr.length - 1; i > 0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextSmaller[i] = arr.length;
            } else {
                nextSmaller[i] = s.peek();
            }
            s.push(i);
        }

        s = new Stack<>();

        // PREVIOUS SMALLER
        for(int i = 0; i < arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = s.peek();
            }
            s.push(i);
        }

        //LARGEST RECTANGLE
        for(int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1;

            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public static int largestRectangleAreaOpti(int[] arr) {
        if(arr.length == 1) return arr[0];

        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            while(!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int ele = st.pop();
                int nse = i, pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, (arr[ele] * (nse - pse - 1)));

                // if(!st.isEmpty()) {
                //     maxArea = Math.max(maxArea, (arr[ele] * (i - st.peek() - 1)));
                // } else {
                //     maxArea = Math.max(maxArea, (arr[ele] * (i - (-1) - 1)));
                // }
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int ele = st.pop();
            int nse = arr.length, pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, (arr[ele] * (nse - pse - 1)));

            // if(!st.isEmpty()) {
            //     maxArea = Math.max(maxArea, (arr[ele] * (arr.length - st.peek() - 1)));
            // } else {
            //     maxArea = Math.max(maxArea, (arr[ele] * (arr.length - (-1) - 1)));
            // }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};

        System.out.println("Area of Largest Rectangle in Histogram = " + largestRectangleArea(arr));
    }
}
