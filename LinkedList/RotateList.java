public class RotateList {
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

    public static Node rotateKTimes(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;
    
        // Step 1: Count length
        int len = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
    
        // Step 2: Make it circular
        tail.next = head;
    
        // Step 3: Find new tail: (len - k % len - 1)th node
        k = k % len;
        int stepsToNewTail = len - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
    
        // Step 4: Break the circle
        head = newTail.next;
        newTail.next = null;
    
        return head;      
    }
    
    public static void main(String[] args) {
        RotateList ll = new RotateList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        // ll.head = ll.rotateKTimes(ll.head, 2);
        printLL();
    }
}
