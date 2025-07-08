// LEETCODE 25

public class ReverseKGroups {
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

    public Node reverseKGroup(Node head, int k) {
        if(head == null || k == 1) return head;

        Node curr = head;
        int len = 0;
        
        while(curr != null && len < k) {
            curr = curr.next;
            len++;
        }

        if(len == k) {
            curr = reverseKGroup(curr, k);

            while(len > 0) {
                Node next = head.next;
                head.next = curr;
                curr = head;
                head = next;

                len--;
            }

            head = curr;
        }

        return head;
    }

    public Node reverseKGroupIterative(Node head, int k) {
        if(head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;

        while(true) {
            Node KthNode = getKthNode(prevGroupEnd, k);
            if(KthNode == null) break;

            Node groupStart = prevGroupEnd.next;
            Node nextGroupStart = KthNode.next;

            Node curr = groupStart, prev = KthNode.next;

            while(curr != nextGroupStart) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            prevGroupEnd.next = KthNode;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    public static Node getKthNode(Node start, int k) {
        while(start != null && k > 0) {
            start = start.next;
            k--;
        }

        return start;
    }


    public static void main(String[] args) {
        ReverseKGroups ll = new ReverseKGroups();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);

        printLL();

        head = ll.reverseKGroupIterative(head, 4);

        printLL();
    }
}
