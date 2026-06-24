package Tries;

public class Tries2 {
    static class Node {
        Node[] child = new Node[26];
        int endCount, freqCount;

        public Node() {
            endCount = freqCount = 0;
        }
    }

    private static Node root;

    private static void insert(String str) {
        Node curr = root;

        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if(curr.child[idx] == null) curr.child[idx] = new Node();
            curr = curr.child[idx];
            curr.freqCount++;
        }

        curr.endCount++;
    }

    private static int countWordsEqualTo(String str) {
        Node curr = root;

        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if(curr.child[idx] == null) return 0;
            curr = curr.child[idx];
        }

        return curr.endCount;
    }

    private static int countWordsStartWith(String str) {
        Node curr = root;

        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if(curr.child[idx] == null) return 0;
            curr = curr.child[idx];
        }

        return curr.freqCount;
    }

    private static void erase(String str) {
        Node curr = root;

        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            curr = curr.child[idx];
            curr.freqCount--;
        }

        curr.endCount--;
    }

    public static void main(String[] args) {
        root = new Node();

        insert("apple");
        insert("apple");
        insert("apps");
        insert("appl");
        insert("apps");

        System.out.println(countWordsEqualTo("apple"));
        System.out.println(countWordsStartWith("appl"));
        erase("apple");
        System.out.println(countWordsStartWith("appl"));
        System.out.println(countWordsEqualTo("apple"));
    }
}
