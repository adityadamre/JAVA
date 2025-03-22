package Basics;
import java.util.*;

public class Complex {
    int real, imag;

    Complex(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    public static Complex add(Complex x, Complex y) {
        return new Complex((x.real + y.real), (x.imag + y.imag));
    }

    public static Complex sub(Complex x, Complex y) {
        return new Complex((x.real - y.real), (x.imag - y.imag));
    }

    public static Complex product(Complex x, Complex y) {
        return new Complex((x.real * y.real) - (x.imag * y.imag), (x.real * y.imag) + (x.imag * y.real));
    }

    public void display() {
        if(real == 0 && imag != 0) {
            System.out.println(imag + "i");
        } else if(real != 0 && imag == 0) {
            System.out.println(real);
        } else {
            System.out.println(real + " + " + imag + "i");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;
        System.out.println("Enter real part for first number :");
        a = sc.nextInt();
        System.out.println("Enter imaginary part for first number :");
        b = sc.nextInt();
        System.out.println("Enter real part for second number :");
        c = sc.nextInt();
        System.out.println("Enter imaginary part for second number :");
        d = sc.nextInt();

        Complex first = new Complex(a, b);
        Complex second = new Complex(c, d);

        sc.close();

        Complex third = Complex.add(first, second);
        Complex fourth = Complex.sub(first, second);
        Complex fifth = Complex.product(first, second);

        third.display();
        fourth.display();
        fifth.display();
    }
}
