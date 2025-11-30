package Basics;

public class Catalan {
    private static int catalan(int n) {
        long res = 1;

        for(int i = 0; i < n; i++) {
            res = res * (2L * n - i) / (i + 1);
        }

        return (int) (res / (n + 1));
    }
    
    public static void main(String[] args) {
        System.out.println(catalan(19));
    }
}