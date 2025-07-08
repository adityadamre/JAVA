// LEETCODE 2

public class AddTwoNo {
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


    public static Node addRev(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if(l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum/10;
            current.next = new Node(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        AddTwoNo ll = new AddTwoNo();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        Node head1 = head;

        head = null;
        tail = null;
        size = 0;

        AddTwoNo ll1 = new AddTwoNo();
        ll1.addLast(4);
        ll1.addLast(5);
        ll1.addLast(6);
        Node head2 = head;


        Node newHead = addRev(head1, head2);

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
