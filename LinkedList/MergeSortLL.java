public class MergeSortLL {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node merge(Node head1, Node head2) {
        Node dummyNode = new Node(0);
        Node head = dummyNode;
        
        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                head.next = head1;
                head = head.next;
                head1 = head1.next;
            } else {
                head.next = head2;
                head = head.next;
                head2 = head2.next;
            }
        }
        
        while(head1 != null) {
            head.next = head1;
            head = head.next;
            head1 = head1.next;
        }
        
        while(head2 != null) {
            head.next = head2;
            head = head.next;
            head2 = head2.next;
        }
        
        return dummyNode.next;
    }
    
    public static Node mergeSort(Node head) {
        if(head.next == null) return head;
        
        Node mid;
        if(head.next.next != null){
            Node slow = head, fast = head;
            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            mid = slow.next;
            slow.next = null;
        } else {
            mid = head.next;
            head.next = null;
        }
        
        head = mergeSort(head);
        mid = mergeSort(mid);
        head = merge(head, mid);
        
        return head;
    }

    public static void printLL(Node head) {
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

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(7);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(6);

        head = mergeSort(head);
        printLL(head);
    }
}
