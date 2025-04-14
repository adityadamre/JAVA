
import java.util.*;

public class PairSum1 {
    static Boolean pairSum(ArrayList<Integer> pairs, int target) {
        int lp = 0, rp = pairs.size() - 1;
        while (lp < rp) {
            if(pairs.get(lp) + pairs.get(rp) == target) {
                return true;
            } else if(pairs.get(lp) + pairs.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> pairs = new ArrayList<>();
        pairs.add(1);
        pairs.add(2);
        pairs.add(3);
        pairs.add(4);
        pairs.add(5);

        System.out.println(pairSum(pairs, 7));
    }
}
