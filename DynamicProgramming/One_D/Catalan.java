package DynamicProgramming.One_D;
import java.util.*;

public class Catalan {
    private static int catalan(int n) {
        long res = 1;

        for(int i = 0; i < n; i++) {
            res = res * (2L * n - i) / (i + 1);
        }

        return (int) (res / (n + 1));
    }

    private static int catalanMem(int n, int[] dp) {
        if(n == 0 || n == 1) return 1;

        if(dp[n] != -1) return dp[n];
        
        dp[n] = 0;
        for(int i = 0; i < n; i++) {
            dp[n] += catalanMem(i, dp) * catalanMem(n - i - 1, dp);
        }

        return dp[n];
    }

    private static int catalanTab(int n) {
        if(n == 0 || n == 1) return 1;

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        System.out.println(catalan(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(catalanMem(n, dp));

        System.out.println(catalanTab(n));

        sc.close();
    }
}