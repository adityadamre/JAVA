import java.util.*;

// LEETCODE 71
public class SimplifyPath {
    public static String simplifyPath(String str) {
        Deque<String> deq = new ArrayDeque<>();
        String[] parts = str.split("/");
        StringBuilder result = new StringBuilder();

        for(String part : parts) {
            if(part.equals("") || part.equals(".")) {
                continue;
            } else if(part.equals("..")) {
                if(!deq.isEmpty()) deq.pop();
            } else {
                deq.push(part);
            }
        }

        while(!deq.isEmpty()) {
            result.insert(0, "/" + deq.pop());
        }

        return result.length() == 0 ? "/" : result.toString();
    }


    public static void main(String[] args) {
        String str = "/home/user/Documents/../Pictures/";

        System.out.println(simplifyPath(str));
    }
}
