package Queue;

public class CircularQ {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            size = n;
            rear = -1;
            front = -1;
            arr = new int[n];
        }
        
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return front == (rear + 1) % size;
        }

        public static void add(int data) {    //O(1)
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }

            if(front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public static int remove() {    // O(1)
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int remove = arr[front];

            if(rear == front) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            
            return remove;
        }

        public static int peek() {    // O(1)
            if(isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }
    }


    public static void main(String[] args) {
        // Queue q = new Queue(3);
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);
        // q.add(6);

        // for(int i = 0; i < 3; i++) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }
}
