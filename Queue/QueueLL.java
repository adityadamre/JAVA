package Queue;
import java.util.*;

public class QueueLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;
        
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {    //O(1)
            Node newNode = new Node(data);
            
            if(isEmpty()) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {    // O(1)
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = head.data;

            if(head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }

            return front;
        }

        public static int peek() {    // O(1)
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return head.data;
        }
    }

    public static void queueReversal(Queue q) {
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()) {
            s.push(q.remove());
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);

        queueReversal(q);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
