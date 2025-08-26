package Bit_Manipulation;

public class Exponentiation {
    public static int fastExponentiation(int x, int n) {
        int ans = 1;
        while(n > 0) {
            if((n & 1) != 0) {
                ans = x * ans;
            }
            x = x * x;
            n = n >> 1;
        }
        return ans;
    }

    public static int modularExponentiation(int x, int n, int a) {
        int ans = 1;
        while(n > 0) {
            if((n & 1) != 0) {
                ans = x * ans;
            }
            x = x * x;
            n = n >> 1;
        }
        return ans % a;
    }

    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        // a = a + b;
        // b = a - b;
        // a = a - b;

        System.out.println("a = " + a + ", b = " + b);
    }

    public static void upperToLower(char ch) {
        //Trick to convert from Uppercase to Lowercase
        System.out.println((char) (ch | ' '));
    }

    public static boolean powerOfTwo(int n) {   // Return true if n = 2^x
        return n > 0 && (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        int x = 5, n = 4, a = 20;
        System.out.println(fastExponentiation(x, n));
        System.out.println(modularExponentiation(x, n, a));
        swap(x, a);

        char ch = 'D';
        upperToLower(ch);
    }
}
