package DynamicProgramming.Subsequences;
import java.util.*;

public class RodCutting {
    private static int helper(int[] price, int[][] dp, int idx, int n) {
        if(idx == 0) {
            return price[idx] * n;
        }
        
        if(dp[idx][n] != -1) return dp[idx][n];
        
        int notTake = helper(price, dp, idx - 1, n);
        int take = Integer.MIN_VALUE;
        if(n > idx) take = price[idx] + helper(price, dp, idx, n - idx - 1);
        
        return dp[idx][n] = Math.max(take, notTake);
    }
    
    public static int cutRodMem(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        return helper(price, dp, n-1, n);
    }

    public static int cutRodTabOpti(int[] price) {
        int len = price.length;
        int[] prev = new int[len+1];

        for(int i = 0; i <= len; i++) prev[i] = price[0] * (i);

        for(int idx = 1; idx < len; idx++)  {
            for(int N = 0; N <= len; N++) {
                int notTake = prev[N];
                int take = Integer.MIN_VALUE;
                if(N > idx) take = price[idx] + prev[N - idx - 1];

                prev[N] = Math.max(take, notTake);
            }
        }
        
        return prev[len];
    }

    public static void main(String[] args) {
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        // price[i] represent the price of rod of length -> i + 
        
        System.out.println(cutRodMem(price));
        
        System.out.println(cutRodTabOpti(price));
    }
}
