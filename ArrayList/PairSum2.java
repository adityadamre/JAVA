import java.util.ArrayList;

public class PairSum2 {
    static Boolean pairSum(ArrayList<Integer> pairs, int target) {
        int pivot = -1;
        for(int i = 0; i < pairs.size() - 1; i++) {
            if(pairs.get(i) > pairs.get(i+1)) {
                pivot = i;
            }
        }
        int rp = pivot, lp = pivot + 1;

        while (lp != rp) {
            if(pairs.get(lp) + pairs.get(rp) == target) {
                return true;
            } else if(pairs.get(lp) + pairs.get(rp) < target) {
                lp = (lp+1) % pairs.size();
            } else {
                rp = (rp+pairs.size()-1) % pairs.size();
            }
        }

        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> pairs = new ArrayList<>();
        pairs.add(11);
        pairs.add(15);
        pairs.add(6);
        pairs.add(8);
        pairs.add(9);
        pairs.add(10);

        System.out.println(pairSum(pairs, 18));
    }
}
