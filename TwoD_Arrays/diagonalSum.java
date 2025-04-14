package TwoD_Arrays;

public class DiagonalSum {
    public static int diagonal(int arr[][]) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            if(i != arr.length - i -1) {
                sum += arr[i][arr.length - i -1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Diagonal Sum = "+ diagonal(arr));
    }
}



//int start = 0, sum = 0;
//int end = arr.length - 1;
//while(start < arr.length || end >= 0) {
//    sum += arr[start][start];
//    sum += arr[start][end];
//    start++;
//    end--;
//}
//if(arr.length % 2 == 1) {
//    sum -= arr[arr.length / 2][arr.length / 2];
//}