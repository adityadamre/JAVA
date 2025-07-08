// LEETCODE 430

public class FlattenDLL {
    public class Node {
        int data;
        Node next;
        Node prev;
        Node child;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
            this.child = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printLL() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public Node flatten(Node head) {
        if(head == null) return null;

        flattenTail(head);

        return head;
    }

    public Node flattenTail(Node head) {
        Node curr = head;
        Node prev = null;
        
        while(curr != null) {
            Node next = curr.next;

            if(curr.child != null) {
                Node childHead = curr.child;
                Node childTail = flattenTail(curr.child);

                curr.next = childHead;
                childHead.prev = curr;

                if(next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                curr.child = null;

                prev = childTail;
                curr = childTail.next;
            } else {
                prev = curr;
                curr = next;
            }
        }
        
        return prev;
    }

    public static void main(String[] args) {
        FlattenDLL dll = new FlattenDLL();
        
        Node node1 = dll.new Node(1);
        Node node2 = dll.new Node(2);
        Node node3 = dll.new Node(3);
        Node node4 = dll.new Node(4);
        Node node5 = dll.new Node(5);
        Node node6 = dll.new Node(6);
        Node node7 = dll.new Node(7);
        Node node8 = dll.new Node(8);
        Node node9 = dll.new Node(9);
        Node node10 = dll.new Node(10);
        Node node11 = dll.new Node(11);
        Node node12 = dll.new Node(12);
        
        // Set up main level: 1-2-3-4-5-6
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        
        // Set up child of node3: 7-8-9
        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.next = node9;
        node9.prev = node8;
        
        // Set up child of node8: 11-12
        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;
        
        // Set up child of node4: 10
        node4.child = node10;
        
        Node oldHead = node1;

        head = dll.flatten(oldHead);

        System.out.println("Expected: 1-2-3-7-8-11-12-9-4-10-5-6");
        dll.printLL();
    }
}
