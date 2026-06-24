package Basics;
import java.util.*;

public class Prime {
    public static boolean isPrime(int n) {
        for(int i = 2; i < Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> sieveOfErastothenes(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for(int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 2; i <= n; i++) {
            if(prime[i]) res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        sc.close();
        System.out.println(isPrime(num));

        System.out.println(sieveOfErastothenes(num));
    }
}
