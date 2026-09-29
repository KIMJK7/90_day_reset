package Week_6.Day_2;

public class circularQueue {
    class MyCircularQueue {
        int[] queue = new int[5];
        int front = 0;
        int rear = 0;
        int size = 0;

        void enqueue(int value) {
            if (size == queue.length) {
                System.out.println("queue is full");
                return;
            }
            queue[rear] = value;
            rear = (rear + 1) % (queue.length);
            size++;

        }

        int dequeue() {
            if (size == 0) {
                System.out.println("queue is empty");
                return -1;
            }
            int value = queue[front];
            front = (front + 1) % queue.length;
            size--;
            return value;
        }

        int peek() {
            if (size == 0) {
                System.out.println("queue is empty");
                return -1;
            }
            return queue[front];
        }

        public int Front() {
            if (size == 0) {
                return -1;
            }
            return queue[front];
        }

        public int Rear() {
            if (size == 0) {
                return -1;
            }

            return queue[(rear - 1 + queue.length) % queue.length];
        }

        boolean isEmpty() {
            if (size < queue.length) {
                return false;
            }
            return true;

        }

        boolean isFull() {
            if (size == queue.length) {
                return true;
            }
            return false;
        }

        int size() {
            return size;
        }

    }
}
