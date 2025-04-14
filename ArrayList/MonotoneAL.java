import java.util.*;

public class MonotoneAL {
    static Boolean isMonotone(ArrayList<Integer> arr) {
        boolean inc = true, dec = true;
        for(int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i) < arr.get(i+1)) dec = false;
            if(arr.get(i) > arr.get(i+1)) inc = false;
        }

        return inc || dec;
    }

    // static Boolean isMonotone(ArrayList<Integer> arr) {  // MINE
    //     int count = 0;
    //     for(int i = 0; i < arr.size() - 1; i++) {
    //         if(arr.get(i) < arr.get(i + 1)) {
    //             count++;
    //         }
    //     }
    //     if(count == arr.size() - 1) return true;

    //     count = 0;
    //     for(int i = 1; i < arr.size(); i++) {
    //         if(arr.get(i) < arr.get(i - 1)) {
    //             count++;
    //         }
    //     }
    //     if(count == arr.size() - 1) return true;

    //     return false;
    // }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.add(9);
        arr.add(10);

        System.out.println(isMonotone(arr));
    }    
}
