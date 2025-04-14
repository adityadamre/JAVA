
import java.util.*;

public class MostWater {
    static int mostWater(ArrayList<Integer> height) {
        int lp = 0, rp = height.size() - 1;
        int maxWater = 0;

        while(lp < rp) {
            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp;
            int currWater = h*w;
            maxWater = Math.max(currWater, maxWater);
            if(height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(11);
        height.add(5);
        height.add(9);
        height.add(6);
        height.add(8);
        height.add(3);
        height.add(10);

        System.out.println(mostWater(height));
    }
}