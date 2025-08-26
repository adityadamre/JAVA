public class DiagonalTraverse {
    // LEETCODE 498
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] ans = new int[m * n];
        int row = 0, col = 0;
        boolean goingUp = true;

        for(int idx = 0; idx < (m * n); idx++) {
            ans[idx] = mat[row][col];

            if(goingUp) {
                if(col == n - 1) {
                    row++;
                    goingUp = !goingUp;
                } else if(row == 0) {
                    col++;
                    goingUp = !goingUp;
                } else {
                    row--; col++;
                }
            } else {
                if(row == m - 1) {
                    col++;
                    goingUp = !goingUp;
                } else if(col == 0) {
                    row++;
                    goingUp = !goingUp;
                } else {
                    row++; col--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ans = findDiagonalOrder(arr);

        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " -> ");
        }
    }
}
