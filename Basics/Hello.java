package Basics;
// import java.util.Scanner;


// MULTIPLE INHERITANCE
//
// interface Herbivore {
//     void eats();
// }
// interface Carnivore {
//     void eats();
// }
// class Bear implements Herbivore, Carnivore {
//     public void eats() {
//         System.out.println("Bear is an Omnivore");
//     }
// }


public class Hello {
    // static int factorial(int n) {
    //     if(n == 0) {
    //         return 1;
    //     }
    //     int fn = n * factorial(n-1);
    //     return fn;
    // }

    // static int sumN(int n) {
    //     if(n == 1) {
    //         return 1;
    //     }
    //     int ans = n + sumN(n - 1);
    //     return ans;
    // }

    // static int nthFibonacci(int n) {
    //     if(n == 0) {
    //         return 0;
    //     } else if(n == 1) {
    //         return 1;
    //     }
    //     int nth = nthFibonacci(n - 1) + nthFibonacci(n - 2);
    //     return nth;
    // }

    // static boolean isSorted(int arr[], int i) {
    //     if(i == arr.length - 1) {
    //         return true;
    //     }
    //     if(arr[i] > arr[i+1]) {
    //         return false;
    //     }

    //     return isSorted(arr, i+1);
    // }

    // static int firstOccurence(int arr[], int i, int n) {
    //     if(i >= arr.length) {
    //         return -1;
    //     }
    //     if(arr[i] == n) {
    //         return i;
    //     }
    //     return firstOccurence(arr, i + 1, n);
    // }

    // static int lastOccurence(int arr[], int i, int n) {
    //     if(i < 0) {
    //         return -1;
    //     }
    //     if(arr[i] == n) {
    //         return i;
    //     }
    //     return lastOccurence(arr, i - 1, n);
    // }

    // static int power(int x, int n) {
    //     if(n == 0) {
    //         return 1;
    //     }
    //     return x * power(x, n - 1);
    // }
    
    // static int optimizedPower(int x, int n) {
    //     if(n == 0) {
    //         return 1;
    //     }
    //     int halfPower = optimizedPower(x, n/2);
    //     if(n % 2 == 0) {
    //         return halfPower * halfPower;
    //     } else {
    //         return x * halfPower * halfPower;
    //     }
    // }

    // static int tilingProblem(int n) { // Floor size a X n, Tile Size a X 1
    //     if(n == 0 || n == 1) {
    //         return 1;
    //     }
    //     int nm1 = tilingProblem(n - 1);
    //     int nm2 = tilingProblem(n - 2);
    //     return nm1 + nm2;
    // }

    // static void removeDuplicate(String str, int index, StringBuilder newStr, boolean map[]) { //String is havimg small leters only
    //     if(index == str.length()) {
    //         System.out.println(newStr);
    //         return;
    //     }

    //     if(map[str.charAt(index) - 'a'] == true) {
    //         removeDuplicate(str, index + 1, newStr, map);
    //     } else {
    //         map[str.charAt(index) - 'a'] = true;
    //         removeDuplicate(str, index + 1, newStr.append(str.charAt(index)), map);
    //     }
    // }

    // static int friendsPairing(int n) {
    //     if(n == 1) {
    //         return 1;
    //     } else if(n == 2) {
    //         return 2;
    //     }

    //     return friendsPairing(n-1) + ((n - 1) * friendsPairing(n - 2));
    // }

    // static void binaryString(int n, int lastPlace, String str) {
    //     if(n == 0) {
    //         System.out.println(str);
    //         return;
    //     }

    //     binaryString(n-1, 0, str + "0");
    //     if(lastPlace == 0) {
    //         binaryString(n-1, 1, str + "1");
    //     }
    // }

    // static void number(int arr[], int index, int key) {
    //     if(index == arr.length) {
    //         return;
    //     } else if(arr[index] == key) {
    //         System.out.print(index + " ");
    //     }
    //     number(arr, index + 1, key);
    // }

    // static void printNumber(int n) {
    //     if(n == 0) {
    //         return;
    //     }
    //     String number[] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    //     int lastDigit = n % 10;
    //     n = n/10;
    //     printNumber(n);
    //     System.out.print(number[lastDigit] + " ");
    // }

    // static int countSubstring(String str, int i) { // Starting and ending with same letter
    //     if(i > str.length() - 1) {
    //         return 0;
    //     }
    //     int count = 0;
    //     for(int j = str.length() - 1; j >= i; j--) {
    //         if(str.charAt(j) == str.charAt(i)) {
    //             count++;
    //         }
    //     }
    //     return count + countSubstring(str, i + 1);
    // }

    // static void hanoiTower(int n, String src, String helper, String dest) { //Disc 1 at Top & Disc n at Bottom
    //     if(n == 1) {
    //         System.out.println("Transfer disc " + n + " from " + src + " to " + dest);
    //         return;
    //     }

    //     hanoiTower(n - 1, src, dest, helper);
    //     System.out.println("Transfer disc " + n + " from " + src + " to " + dest);
    //     hanoiTower(n - 1, helper, src, dest);
    // }

    

    public static void main(String[] args) {

        // System.out.println("Hello World");

        // Scanner sc = new Scanner(System.in);
        
        // int a = sc.nextInt();
        // if(a < 0) {
        //     System.out.println("Negative");
        // } else if(a > 0) {
        //     System.out.println("Positive");
        // } else {
        //     System.out.println("It must be zero then!");
        // }


        // int dayNo = sc.nextInt();
        // switch(dayNo) {
        //     case 1 : System.out.println("Monday");
        //                 break;
        //     case 2 : System.out.println("Tuesday");
        //                 break;
        //     case 3 : System.out.println("Wednesday");
        //                 break;
        //     case 4 : System.out.println("Thursday");
        //                 break;
        //     case 5 : System.out.println("Friday");
        //                 break;
        //     case 6 : System.out.println("Saturday");
        //                 break;
        //     case 7 : System.out.println("Sunday");
        //                 break;
        //     default : System.out.println("Invalid input");
        // }


        // int num = sc.nextInt();
        // int rev = 0, lastDigit;
        // while(num > 0) {
        //     lastDigit = num % 10;
        //     rev = (rev * 10) + lastDigit;
        //     num = num / 10;
        // }
        // System.out.println(rev + "\nReversed!");


        // int n = sc.nextInt();
        // int fact = 1;
        // for(int i = 2; i <= n; i++) {
        //     fact *= i;
        // }
        // System.out.println("Factorial of " + n + " is " + fact);


        // System.out.print("Enter No of Rows : ");
        // int rows = sc.nextInt();
        // System.out.print("Enter No of Columns : ");
        // int cols = sc.nextInt();
        // for(int i = 1; i <= rows; i++) {
        //     for(int j = 1; j <= cols; j++) {
        //         if(i == 1 || i == rows || j == 1 || j == cols) {
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = n; i >= 1; i--) {
        //     for(int j = 1; j <= i-1; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= n-i+1; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        //
        // OR
        //
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i+1; j++) {
        //         System.out.print(j + " ");
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt(), num = 1;
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print(num + " ");
        //         num++;
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= i; j++) {
        //         if((i + j) % 2 == 0) {
        //             System.out.print("1 ");
        //         } else {
        //             System.out.print("0 ");
        //         }
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     for(int j = 1; j <= 2 * (n-i); j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // for(int i = n; i >= 1; i--) {
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     for(int j = 1; j <= 2 * (n-i); j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= n; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= n; j++) {
        //         if(i == 1 || i == n || j == 1 || j == n) {
        //                 System.out.print("*");
        //             } else {
        //                 System.out.print(" ");
        //             }
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= (2 * i) - 1; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // for(int i = n; i >= 1; i--) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= 2 * i - 1; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }


        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = 1; j <= i; j++) {
        //         System.out.print(i + " ");
        //     }
        //     System.out.println();
        // }

        
        // System.out.print("Enter size : ");
        // int n = sc.nextInt();
        // for(int i = 1; i <= n; i++) {
        //     for(int j = 1; j <= n-i; j++) {
        //         System.out.print(" ");
        //     }
        //     for(int j = i; j >= 1; j--) {
        //         System.out.print(j);
        //     }
        //     for(int j = 2; j <= i; j++) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
    }
}