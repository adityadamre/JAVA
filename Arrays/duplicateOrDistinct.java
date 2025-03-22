package Arrays;

public class duplicateOrDistinct {
    public static boolean duplicate(int arr[]) {
        for(int i = 0; i < arr.length-1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 5, 4, 6};
        if(duplicate(arr)) {
            System.out.println("Some elements of array are repeated");
        } else {
            System.out.println("All elements of array are distinct/unique");
        }
    }
}