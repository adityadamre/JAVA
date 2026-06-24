package DynamicProgramming.Subsequences;
import java.util.*;

public class Knapsack {
    private static int helper(int[] val, int[] wt, int[][] dp, int W, int idx) {
        if(idx == 0) {
            if(W >= wt[0]) return val[0];
            return 0;
        }
        if(dp[idx][W] != -1) return dp[idx][W];
        
        int notTake = helper(val, wt, dp, W, idx-1);
        int take = Integer.MIN_VALUE;
        if(W >= wt[idx]) take = val[idx] + helper(val, wt, dp, W-wt[idx], idx-1);
        
        return dp[idx][W] = Math.max(take, notTake);
    }

    public static int knapsackMem(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return helper(val, wt, dp, W, n-1);
    }

    public static int knapsackTab(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n][W+1];
        
        for(int i = wt[0]; i <= W; i++) dp[0][i] = val[0];

        for(int i = 1; i < n; i++) {
            for(int j = 0; j <= W; j++) {
                int notTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= j) take = val[i] + dp[i-1][j - wt[i]];

                dp[i][j] = Math.max(take, notTake);
            }
        }

        return dp[n-1][W];
    }

    public static int knapsackTabOpti(int[] val, int[] wt, int W) {
        int n = val.length;
        int[] dp = new int[W+1];
        
        for(int i = wt[0]; i <= W; i++) dp[i] = val[0];

        for(int i = 1; i < n; i++) {
            for(int j = W; j >= 0; j--) {
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= j) take = val[i] + dp[j - wt[i]];

                dp[j] = Math.max(take, notTake);
            }
        }

        return dp[W];
    }

    private static int helper2(int[] val, int[] wt, int[][] dp, int W, int idx) {
        if(idx == 0) {
            return (W / wt[0]) * val[0];
        }

        if(dp[idx][W] != -1) return dp[idx][W];

        int notTake = helper2(val, wt, dp, W, idx-1);
        int take = Integer.MIN_VALUE;
        if(wt[idx] <= W) take = val[idx] + helper2(val, wt, dp, W - wt[idx], idx);

        return dp[idx][W] = Math.max(take, notTake);
    }

    public static int unboundedKnapsackMem(int[] val, int[] wt, int W) {
        int n = val.length;
        int[][] dp = new int[n][W+1];

        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        return helper2(val, wt, dp, W, n-1);
    }

    public static int unboundedKnapsackTabOpti(int[] val, int[] wt, int W) {
        int n = val.length;
        int[] prev = new int[W+1];
        
        for(int i = 0; i <= W; i++) {
            prev[i] = (i / wt[0]) * val[0];
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= W; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if(j >= wt[i]) take = val[i] + prev[j - wt[i]];
                
                prev[j] = Math.max(notTake, take);
            }
        }
        
        return prev[W];
    }

    public static void main(String[] args) {
        int[] val = { 40, 30, 60 };
        int[] wt = { 3, 2, 5 };

        System.out.println(knapsackMem(val, wt, 5));

        System.out.println(knapsackTab(val, wt, 5));

        System.out.println(knapsackTabOpti(val, wt, 5));

        int[] val1 = { 20, 50, 80 };
        int[] wt1 = { 2, 3, 5 };

        System.out.println(unboundedKnapsackMem(val1, wt1, 6));
        
        System.out.println(unboundedKnapsackTabOpti(val1, wt1, 6));
    }
}
