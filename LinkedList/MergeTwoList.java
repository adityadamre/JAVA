// LEETCODE 21

public class MergeTwoList {
    static class Node {
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

    public static Node mergeList(Node list1, Node list2) {
        Node newHead = new Node(0);
        Node curr = newHead;

        while(list1 != null && list2 != null) {
            if(list1.data <= list2.data) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if(list1 != null) curr.next = list1;

        if(list2 != null) curr.next = list2;

        return newHead.next;
    }

    public static void main(String[] args) {
        MergeTwoList ll = new MergeTwoList();
        ll.addLast(1);
        ll.addLast(12);
        ll.addLast(31);
        Node head1 = head;

        head = null;
        tail = null;
        size = 0;

        MergeTwoList ll1 = new MergeTwoList();
        ll1.addLast(4);
        ll1.addLast(15);
        ll1.addLast(26);
        Node head2 = head;

        Node newHead = mergeList(head1, head2);

        Node temp = newHead;

        if (temp == null) {
            System.out.println("The LL is empty");
            return;
        }

        while (temp!= null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
