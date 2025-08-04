package TwoPntr_SlidingWindow;

public class SortColors {
    // Dutch National Flag Algorithm
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while(mid <= high) {
            if(arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                mid++;
                low++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 0, 0, 1, 1, 2};

        sortColors(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
