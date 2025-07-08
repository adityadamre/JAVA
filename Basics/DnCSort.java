package Basics;

public class DnCSort {
    
    // -------MERGE SORT-------
    static void merge(int arr[], int st, int mid, int end) {
        int temp[] = new int[end - st + 1];
        int i = st, j = mid + 1, k = 0;

        while(i <= mid && j <= end) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= end) {
            temp[k++] = arr[j++];
        }

        for(k = 0, i = st; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    static void mergeSort(int arr[], int st, int end) {
        if(st >= end) {
            return;
        }
        int mid = st + (end - st)/2;

        mergeSort(arr, st, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, st, mid, end);
    }

    // -------QUICK SORT-------
    static int partition(int arr[], int st, int end) {
        int pivot = arr[end];
        int i = st - 1;

        for(int j = st; j < end; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = arr[end];
        arr[end] = arr[i];
        arr[i] = temp;

        return i;
    }

    static void quickSort(int arr[], int st, int end) {
        if(st >= end) {
            return;
        }
        int pIdx = partition(arr, st, end);
        
        quickSort(arr, st, pIdx - 1);
        quickSort(arr, pIdx + 1, end);
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, 4, 9, 2, 3, 13};
        quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
