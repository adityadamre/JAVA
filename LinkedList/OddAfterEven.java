public class OddAfterEven {
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

    public void oddAfterEven() {
        Node end = head;
        Node prev = null, curr = head;

        while(end.next != null) {
            end = end.next;
        }

        Node newEnd = end;

        while(curr.data % 2 != 0 && curr != null) {
            newEnd.next = curr;
            curr = curr.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }

        if(curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if(curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    newEnd.next = curr;
                    curr = prev.next;
                    newEnd = newEnd.next;
                }
            }
        } else {
            prev = curr;
        }

        if(end.data % 2 != 0 && newEnd != end) {
            prev.next = end.next;
            end.next = null;
            newEnd.next = end;
        }
    }


    public static void main(String[] args) {
        OddAfterEven ll = new OddAfterEven();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);

        printLL();
        ll.oddAfterEven();
        printLL();
    }
}