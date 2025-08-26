package Backtracking;

import java.util.*;

public class GenerateParentheses {
    private static void helper(int n, List<String> res, StringBuilder sb, int open, int close) {
        if(sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append('(');
            helper(n, res, sb, open+1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open) {
            sb.append(')');
            helper(n, res, sb, open, close+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, res, new StringBuilder(), 0, 0);

        return res;
    }

    public static void main(String[] args) {
        List<String> ans = new ArrayList<>(generateParenthesis(4));

        System.out.println(ans);
    }
}
