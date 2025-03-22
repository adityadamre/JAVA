package TwoD_Arrays;

public class sortedSearch {
    public static void staircaseSearch(int arr[][], int key) {
        int row = 0, col = arr[0].length - 1;
        while(row < arr.length && col >= 0) {
            if(arr[row][col] == key) {
                System.out.println("The key is found at index location (" + row + ", " + col + ")");
                return;
            } else if(key > arr[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        // int row = arr.length - 1, col = 0;
        // while(row >= 0 && col < arr[0].length) {
        //     if(arr[row][col] == key) {
        //         System.out.println("The key is found at index location (" + row + ", " + col + ")");
        //         return;
        //     } else if(key > arr[row][col]) {
        //         col++;
        //     } else {
        //         row--;
        //     }
        // }

        // Both methods have same worst case time complexity --> O(n.m)
    }

    public static void main(String[] args) {
        int arr[][] = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50}};
        int key = 33;
        staircaseSearch(arr, key);
    }
}
