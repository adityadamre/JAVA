package Backtracking;

public class RatMaze {
    static int N;

    static boolean isSafe(int maze[][], int x, int y, int sol[][]) {
        N = maze.length;
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1 && sol[x][y] == 0);
    }

    static boolean ratMaze(int maze[][], int x, int y, int sol[][]) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y, sol)) {
            sol[x][y] = 1;

            if (ratMaze(maze, x + 1, y, sol)) return true;
            
            if (ratMaze(maze, x, y + 1, sol)) return true;
            
            if (ratMaze(maze, x - 1, y, sol)) return true;
            
            if (ratMaze(maze, x, y - 1, sol)) return true;
            
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int maze[][] = { {1, 0, 1, 0, 1},
                         {1, 1, 1, 0, 1},
                         {1, 0, 1, 1, 0},
                         {0, 1, 1, 0, 1},
                         {1, 0, 1, 1, 1} };
        
        int solution[][] = new int[maze.length][maze.length];
        if (ratMaze(maze, 0, 0, solution)) {
            System.out.println("Solution exists");
            printSolution(solution);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}
