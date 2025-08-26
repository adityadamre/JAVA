public class RotateImage {
    private static void reverse(int[] arr) {
        int st = 0, end = arr.length - 1;

        while(st < end) {
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;

            st++; end--;
        }
    }

    public static void rotate(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {  // TRANSPOSE
            for(int j = i+1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            reverse(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        rotate(arr);
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
