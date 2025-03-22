package Backtracking;

public class knightsTour {
    private static final int rowMoves[] = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int colMoves[] = {1, 2, 2, 1, -1, -2, -2, -1};
    private static final int N = 8;

    static void printBoard(int board[][]) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isValid(int board[][], int row, int col) {
        return row >=0 && row < N && col >= 0 && col < N && board[row][col] == -1;
    }

    static boolean knightTour(int board[][], int row, int col, int moveCount) {
        if(moveCount == N * N) {
            return true;
        }

        for(int i = 0; i < 8; i++) {
            int nextRow = row + rowMoves[i];
            int nextCol = col + colMoves[i];

            if(isValid(board, nextRow, nextCol)) {
                board[nextRow][nextCol] = moveCount;
                if(knightTour(board, nextRow, nextCol, moveCount + 1)) {
                    return true;
                }
                board[nextRow][nextCol] = -1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int board[][] = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        if(knightTour(board, 0, 0, 1)) {
            printBoard(board);
        } else {
            System.out.println("No solution exist");
        }
    }
}
