package BinarySearch;

public class NthRoot {
    // return -1 if exceeding -> pro > m
    // return 0 if voila case -> pro == m
    // return 1 if pro < m
    private static int helper(int mid, int n, int m) {
        long pro = 1;
        for(int i = 0; i < n; i++) {
            pro *= mid;
            if(pro > m) return -1;
        }
        if(pro == m) return 0;
        return 1;
    }

    public static int nthRoot(int n, int m) {
        int low = 1, high = m;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int ans = helper(mid, n, m);

            if(ans == 0) return mid;
            else if(ans == -1) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(10, (int) 1024));
    }
}
