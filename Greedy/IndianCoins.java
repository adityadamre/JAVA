package Greedy;
import java.util.*;

public class IndianCoins {
    public static int minCoins(int[] coins, int value) {
        int count = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = coins.length - 1; i >= 0; i--) {    // We'll have to sort array if not sorted
            while(value >= coins[i]) {
                count++;
                ans.add(coins[i]);
                value -= coins[i];
            }
        }

        for(int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

        return count;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int value = 599;
        
        System.out.println("\nMinimum No. of coins: " + minCoins(coins, value));
    }
}
