import java.util.*;

public class DuplicateOrDistinct {
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

    public static boolean duplicateOpti(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int num: arr) {
            if(set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }
    
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 5, 4, 6};
        if(duplicateOpti(arr)) {
            System.out.println("Some elements of array are repeated");
        } else {
            System.out.println("All elements of array are distinct/unique");
        }
    }
}