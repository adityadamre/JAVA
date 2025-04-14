package Basics;

// CONSTRUCTOR CHAINING

public class ChainWithinClass {
    ChainWithinClass() {
        System.out.println("This is the no-arg constructor.");
    }

    ChainWithinClass(int y) {
        this(); // Calls the no-arg constructor
        int var1 = y;
        System.out.println("You passed one argument: " + var1);
    }

    ChainWithinClass(int a, int b) {
        this(3); // Calls the constructor with one argument
        int var2 = a;
        int var3 = b;
        System.out.println("You passed two arguments: " + var2 + " and " + var3);
    }

    public static void main(String[] args) {
        // ChainWithinClass chainObj = new ChainWithinClass(2, 4);
    }
}
