public class CountInversions {
    private static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int[] temp = new int[high - low + 1];
        int l = low, r = mid + 1, ptr = 0;

        while(l <= mid && r <= high) {
            if(arr[l] <= arr[r]) {
                temp[ptr++] = arr[l++];
            } else {
                count += (mid - l + 1);
                temp[ptr++] = arr[r++];
            }
        }

        while(l <= mid) {
            temp[ptr++] = arr[l++];
        }

        while(r <= high) {
            temp[ptr++] = arr[r++];
        }

        for(int i = 0; i < temp.length; i++) {
            arr[low++] = temp[i];
        }

        return count;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if(low >= high) return count;

        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    public static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};

        int count = countInversions(arr);
        System.out.println("Inversion Count = " + count);
    }
}
