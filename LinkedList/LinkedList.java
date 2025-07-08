
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
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public static void printLL() {
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

    public int recSearch(Node head, int target) {
        if(head == null) {
            return -1;
        }
        
        if(head.data == target) {
            return 0;
        }
        int idx = recSearch(head.next, target);
        if(idx == -1) {
            return -1;
        }

        return idx + 1;
    }
    // public int recSearch(int target) {
    //     return helper(head, target);
    // }

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

    // LEETCODE 19
    public void deleteNthFromEnd(int n) {
        // ---If told to find size, just create a temp node and traverse LL---

        if(n == size) {
            head = head.next;
            return;
        }

        int i = 0;
        Node prev = head;
        int iToFind = size - n - 1;
        while(i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // SLOW-FAST APPROACH or FLOYD'S TORTOISE-HARE ALGO
    public Node findMid() { //When in doubt -> choose right
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

    // LEETCODE 141
    public static boolean isCycle() {  // Floyd's Cycle Finding Algo.
        Node slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    // LEETCODE 142
    public static void removeCycle() {
        Node slow = head, fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle == false) {
            return;
        }

        slow = head;
        Node prev = null;
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = null;
    }

    public Node getMid(Node head) { // When in doubt -> choose left
        Node slow = head, fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node merge(Node left, Node right) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(right != null && left != null) {
            if(left.data <= right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        while(left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while(right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);

        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    // LEETCODE 143
    public void zigzag() {
        if(head == null || head.next == null) {
            return;
        }

        Node slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        Node prev = null, curr = mid.next;
        mid.next = null;
        Node next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node LH = head, RH = prev;
        Node nextL, nextR;
        while(LH != null && RH != null) {
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;

            LH = nextL;
            RH = nextR;
        }
    }
  
    // LEETCODE 160
    public static Node intersectionPoint(Node headA, Node headB) {
        if(headA == null || headB == null) return null;

        Node a = headA, b = headB;

        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
    

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);

        printLL();
        // ll.zigzag();
        // printLL();
    }
}
