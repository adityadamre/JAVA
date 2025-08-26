public class SetMatrixZero {
    public static void setMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int col0 = 1;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if(j != 0) {
                        arr[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr[0].length; j++) {
                if(arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if(arr[0][0] == 0) {
            for(int j = 0; j < n; j++) arr[0][j] = 0;
        }
        if(col0 == 0) {
            for(int i = 0; i < m; i++) arr[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1, 0},
                        {1, 1, 1, 0},
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                      };

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        setMatrix(arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}