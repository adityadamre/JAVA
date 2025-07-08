import java.util.*;

public class PracticeStack {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void printLL() {
        Node temp = head;
        if (head == null) {
            System.out.println("The LL is empty");
        }

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // LEETCODE 234
    public static boolean isPallindrome(Node head) {
        Node curr = head;
        int len = 0;
        Stack<Integer> s = new Stack<>();

        while(curr != null) {
            curr = curr.next;
            len++;
        }

        curr = head;

        for(int i = 0; i < len/2; i++) {
            s.push(curr.data);
            curr = curr.next;
        }

        if(len % 2 != 0) {
            curr = curr.next;
        }

        while(!s.isEmpty() && curr != null) {
            if(s.peek() != curr.data) {
                return false;
            }
            s.pop();
            curr = curr.next;
        }

        return true;
    }
    

    public static void main(String[] args) {
        PracticeStack ll = new PracticeStack();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(2);
        ll.addLast(1);
        // System.out.println(isPallindrome(head));
    }
}