package Tries;

public class Tries {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;  // End Of Word

        public Node() {
            for(int i = 0; i < 26; i++) children[i] = null;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {  // O(L) ---> L is length of longest word
        Node curr = root;

        for(int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {  // O(L)
        Node curr = root;

        for(int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static boolean prefix(String key) {  // O(L)
        Node curr = root;

        for(int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};

        for(int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("theer"));
        System.out.println(search("their"));

        System.out.println(prefix("an"));
        System.out.println(prefix("theire"));
    }
}
