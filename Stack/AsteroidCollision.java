import java.util.*;

// LEETCODE 735
public class AsteroidCollision {
    public static ArrayList<Integer> asteroidCollision(int[] arr) {
        ArrayList<Integer> st = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                st.add(arr[i]);
            } else {
                while(!st.isEmpty() && st.get(st.size() - 1) > 0 && Math.abs(arr[i]) > st.get(st.size() - 1)) {
                    st.remove(st.size() - 1);
                }
                if(!st.isEmpty() && Math.abs(arr[i]) == st.get(st.size() - 1)) {
                    st.remove(st.size() - 1);
                } else if(st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(arr[i]);
                }
            }
        }

        return st;
    }


    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 1, 2, -3, -7, 17, 15, -18, -19};

        ArrayList<Integer> res = asteroidCollision(arr);

        System.out.println(res);
    }
}
