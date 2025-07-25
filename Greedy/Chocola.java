package Greedy;
import java.util.*;

public class Chocola {
    public static int minCost(Integer[] costVer, Integer[] costHor) {
        Arrays.sort(costHor, Comparator.reverseOrder());
        Arrays.sort(costVer, Comparator.reverseOrder());

        int cost = 0;
        int h = 0, v = 0;
        int hp = 1, vp = 1; // HORIZONTAL/VERTICAL PARTS

        while(h < costHor.length && v < costVer.length) {
            if(costHor[h] <= costVer[v]) {
                cost += (hp * costVer[v]);
                vp++;
                v++;
            } else {
                cost += (vp * costHor[h]);
                hp++;
                h++;
            }
        }

        while(h < costHor.length) {
            cost += (vp * costHor[h]);
            hp++;
            h++;
        }

        while(v < costVer.length) {
            cost += (hp * costVer[v]);
            vp++;
            v++;
        }

        return cost;
    }

    public static void main(String[] args) {
        // int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costtHor[] = {4, 1, 2};

        System.out.println(minCost(costVer, costtHor));
    }
}
