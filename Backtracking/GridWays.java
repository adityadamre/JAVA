package Backtracking;
import java.util.*;

public class GridWays {
    // Approach 1
    static int gridWays(int i, int j, int row, int col) { // O(2^n+m) --> Exponential
        if(i == row - 1 && j == col - 1) { // base case
            return 1;
        } else if(i == row || j == col) { // boundary cross
            return 0;
        }
        // Down + Right
        return gridWays(i + 1, j, row, col) + gridWays(i, j + 1, row, col);
    }

    // Approach 2
    static int fact(int n) {
        if(n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    static int gridWaysOpti(int row, int col) { // O(n+m) --> Linear
        return fact(col - 1 + row - 1) / (fact(col - 1) * fact(row - 1));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.close();
        System.out.println("Total ways : " + gridWaysOpti(n, m));
    }
}
