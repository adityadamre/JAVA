package Strings;
import java.util.*;

public class anagrams {
    public static void isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.length() == str2.length()) {
            char str1CharArray[] = str1.toCharArray();
            char str2CharArray[] = str2.toCharArray();

            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(str1CharArray, str2CharArray);

            if(result) {
                System.out.println(str1 + " & " + str2 + " are anagrams of each other.");
            } else {
                System.out.println(str1 + " & " + str2 + " are not anagrams of each other.");
            }
        } else {
            System.out.println(str1 + " & " + str2 + " are not anagrams of each other.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first word : ");
        String str1 = sc.next();
        System.out.print("Enter second word : ");
        String str2 = sc.next();

        isAnagram(str1, str2);

        sc.close();
    }
}
