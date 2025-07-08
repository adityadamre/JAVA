// LEETCODE 725

public class SplitInKParts {
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

    public static Node[] splitInKParts(Node head, int k) {
        Node result[] = new Node[k];

        int len = 0;
        Node curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }

        int partSize = len / k;
        int extraNodes = len % k;

        curr = head;
        for(int i = 0; i < k; i++) {
            Node partHead = curr;
            int size = partSize + (i < extraNodes ? 1:0);

            for(int j = 0; j < size - 1; j++) {
                if(curr != null) curr = curr.next;
            }

            if(curr != null) {
                Node next = curr.next;
                curr.next = null;
                curr = next;
            }

            result[i] = partHead;
        }

        return result;
    }
    

    public static void main(String[] args) {
        SplitInKParts ll = new SplitInKParts();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        System.out.println("Original list :");
        printLL();

        Node parts[] = splitInKParts(head, 3);

        System.out.println("Linked list split in k parts :");
        for(int i = 0; i < parts.length; i++) {
            Node partHead = parts[i];
            while(partHead!= null) {
                System.out.print(partHead.data + "->");
                partHead = partHead.next;
            }
            System.out.println("NULL");
        }
    }
}