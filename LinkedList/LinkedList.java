
public class LinkedList {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void printLL() {
        Node temp = head;
        if(head == null) {
            System.out.println("The LL is empty");
        }

        while(temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void add(int idx, int data) {
        if(head == null) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx-1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public int removeFirst() {
        if(size == 0) {
            System.out.println("The LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("The LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i = 0; i < size-1; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int target) {
        int idx = 0;
        Node temp = head;

        while(temp != null) {
            if(temp.data == target) {
                return idx;
            }
            temp = temp.next;
            idx++;
        }
        return -1;
    }

    public int helper(Node head, int target) {
        if(head == null) {
            return -1;
        }
        
        if(head.data == target) {
            return 0;
        }
        int idx = helper(head.next, target);
        if(idx == -1) {
            return -1;
        }

        return idx + 1;
    }
    public int recSearch(int target) {
        return helper(head, target);
    }

    public void revOrder() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        // ---If told to find size, just create a temp node and traverse LL---

        if(n == size) {
            head = head.next;
            return;
        }

        int i = 1;
        Node prev = head;
        int iToFind = size - n;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // SLOW-FAST or RABBIT-HARE APPROACH
    public Node findMid() {
        Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;   // +1
            fast = fast.next.next;  // +2
        }

        return slow;
    }

    public boolean isPallindrome() {
        if(head == null || head.next == null) {
            return true;
        }

        Node prev = null;
        Node curr = findMid();
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev, left = head;

        while(right != null) {
            if(right.data != left.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(5);
        ll.add(2, 4);
        ll.add(2, 3);

    }
}
