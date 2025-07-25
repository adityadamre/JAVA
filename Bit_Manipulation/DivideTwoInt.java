package Bit_Manipulation;

public class DivideTwoInt {
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;

        for(int i = 31; i >= 0; i--) {
            if((a >> 1) >= b) {
                a -= b << i;
                result += 1 << i;
            }
        }

        return ((dividend < 0) ^ (divisor < 0)) ? -result : result;
    }


    public static void main(String[] args) {
        int dividend = 3243, divisor = 3;

        System.out.println(divide(dividend, divisor)); 
    }
}