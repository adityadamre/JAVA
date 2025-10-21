package Heaps;

public class HeapSort {
    public static void maxHeapify(int[] arr, int i, int size) {    // MaxHeap for Ascending Order
        int left = 2*i + 1;
        int right = 2*i + 2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]) maxIdx = left;

        if(right < size && arr[right] > arr[maxIdx]) maxIdx = right;

        if(maxIdx != i) {
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[i];
            arr[i] = temp;

            maxHeapify(arr, maxIdx, size);
        }
    }

    public static void minHeapify(int[] arr, int i, int size) {    // MinHeap for Descending Order
        int left = 2*i + 1;
        int right = 2*i + 2;
        int minIdx = i;

        if(left < size && arr[left] < arr[minIdx]) minIdx = left;

        if(right < size && arr[right] < arr[minIdx]) minIdx = right;

        if(minIdx != i) {
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;

            minHeapify(arr, minIdx, size);
        }
    }

    public static void heapSort(int[] arr) {    // O(n logn)
        int n = arr.length;
        for(int i = n/2; i >= 0; i--) {
            minHeapify(arr, i, n);
        }

        for(int i = n-1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            minHeapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 5, 4, 2, 6, 1};
        heapSort(arr);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
