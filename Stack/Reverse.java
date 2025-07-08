import java.util.*;

public class Reverse {
    public static String revString(String str) {
        Stack<Character> s = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder();

        while(!s.isEmpty()) {
            result.append(s.pop());
        }

        return result.toString();
    }

    public static void pushBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top =  s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void revStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        revStack(s);
        pushBottom(s, top);
    }

    public static void main(String[] args) {
        String str = new String("aytidA");

        String result = revString(str);
        System.out.println(result);

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        revStack(s);
        
        while(!s.isEmpty()) {
            System.out.println(s.peek());;
            s.pop();
        }
    }
}
