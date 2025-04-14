import java.util.*;

public class LonelyAL {
    static ArrayList<Integer> isLonely(ArrayList<Integer> arr) {
        ArrayList<Integer> lonely = new ArrayList<>();
        Collections.sort(arr);

        for(int i = 1; i < arr.size() - 1; i++) {
            if(arr.get(i)+1 < arr.get(i+1) && arr.get(i-1)+1 < arr.get(i)) lonely.add(arr.get(i));
        }

        if(arr.size() == 1) lonely.add(arr.get(0));

        if(arr.size() > 1) {
            if(arr.get(0)+1 < arr.get(1)) lonely.add(arr.get(0));
            if(arr.get(arr.size()-1) > arr.get(arr.size()-2)+1) lonely.add(arr.get(arr.size()-1));
        }
        return lonely;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(10);
        arr.add(18);

        ArrayList<Integer> ans = isLonely(arr);
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i) + " ");
        }
    }
}
