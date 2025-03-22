package Basics;

import java.util.Scanner;

public class decNbin {

    public static int binToDec(int n) {
        int power = 0, dec = 0;
        while(n != 0) {
            int lastDig = n % 10;
            dec = dec + (lastDig * (int) Math.pow(2, power));
            n = n / 10;
            power ++;
        }
        return dec;
    }

    public static int decToBin(int n) {
        int power = 0, bin = 0;
        while(n != 0) {
            int rem = n % 2;
            bin = bin + (rem * (int) Math.pow(10, power));
            n = n / 2;
            power ++;
        }
        return bin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Binary No :");
        int bin = sc.nextInt();
        System.out.println("Decimal No = " + binToDec(bin));

        System.out.println("Enter Decimal No :");
        int dec = sc.nextInt();
        System.out.println("Binary No = " + decToBin(dec));

        sc.close();
    }
}
