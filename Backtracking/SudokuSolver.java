package Backtracking;

public class SudokuSolver {
    static boolean isSafe(int sudoku[][], int row, int  col, int digit) {
        // Row
        for(int i = 0; i < 9; i++) {
            if(sudoku[row][i] == digit) {
                return false;
            }
        }

        // Column
        for(int j = 0; j < 9; j++) {
            if(sudoku[j][col] == digit) {
                return false;
            }
        }

        // MiniGrid
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;
        for(int i = sr; i < sr + 3; i++) {
            for(int j = sc; j < sc + 3; j++) {
                if(sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean sudokuSolver(int sudoku[][], int row, int col) {
        if(row == 9) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit <= 9; digit++) {
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }


    // LEETCODE 36
    static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int digit = board[i][j] - '0';
                    int boxId = (i / 3) * 3 + j / 3;

                    if(rows[i][digit] || cols[j][digit] || boxes[boxId][digit]) {
                        return false;
                    }

                    rows[i][digit] = true;
                    cols[j][digit] = true;
                    boxes[boxId][digit] = true;
                }
            }
        }

        return true;
    }
    
    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        
        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution Exists");
            printSudoku(sudoku);
        } else {
            System.out.println("Solution doesn't Exist");
        }
    }
}
