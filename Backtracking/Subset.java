package Backtracking;

public class Subset {
    static int findSubset(String str, String ans, int i) {
        if(i == str.length()) {
            System.out.println(ans);
            return 1;
        }
        //Choice Yes
        findSubset(str, ans + str.charAt(i), i+1);
        //Choice No
        findSubset(str, ans, i+1);
        return 1;
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, new String(""), 0);
    }
}
