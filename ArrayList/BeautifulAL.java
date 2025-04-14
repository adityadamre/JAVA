import java.util.*;

public class BeautifulAL {

    // -------- RECURSIVE APPROACH --------
    //
    // static ArrayList<Integer> makeBeautiful(int n) {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     divideNConquer(1, 1, ans, n);
    //     return ans;
    // }
    // static void divideNConquer(int start, int increment, ArrayList<Integer> ans, int n) {
    //     if(start + increment > n) {
    //         ans.add(start);
    //         return;
    //     }

    //     divideNConquer(start, 2 * increment, ans, n);
    //     divideNConquer(start + increment, 2 * increment, ans, n);
    // }

    // -------- ITERATIVE APPROACH --------
    //
    static ArrayList<Integer> makeBeautiful(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        while(ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();

            for(Integer e : ans) {
                if(2*e <= n) temp.add(e * 2);
            }

            for(Integer e : ans) {
                if(2*e - 1 <= n) temp.add(2*e - 1);
            }

            ans = temp;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size : ");
        int n = sc.nextInt();

        ArrayList<Integer> beautiful = makeBeautiful(n);
        for(int i = 0; i < beautiful.size(); i++) {
            System.out.print(beautiful.get(i) + " ");
        }

        sc.close();
    }
}
