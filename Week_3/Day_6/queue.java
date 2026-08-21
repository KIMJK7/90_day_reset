package Week_3.Day_6;

import java.util.ArrayDeque;
import java.util.Queue;

// Why would using an ordinary array and repeatedly shifting all elements after a dequeue be inefficient?
// if we use an array, So one dequeue requires moving every remaining element.
//That's O(n) for one dequeue.
//If you dequeue repeatedly, you can end up doing a lot of unnecessary work.
//A proper queue implementation such as ArrayDeque avoids this by maintaining the front and back positions, so enqueue/dequeue are effectively O(1).

public class queue {
    public static void enqueue(Queue<Integer> que, int x) {
        que.offer(x);
    }

    public static void dequeue(Queue<Integer> que) {
        que.poll();
    }

    public static int front(Queue<Integer> que) {
        return que.peek();

    }

    public static boolean isEmpty(Queue<Integer> que) {
        return que.isEmpty();
    }

    public static void main(String[] args) {
        Queue<Integer> que = new ArrayDeque<>();
        enqueue(que, 10);
        enqueue(que, 20);
        enqueue(que, 30);
        enqueue(que, 40);
        enqueue(que, 50);
        System.out.println(front(que)); // 10

        dequeue(que);

        System.out.println(front(que)); // 20

        dequeue(que);

        System.out.println(front(que)); // 30

        System.out.println(isEmpty(que)); // false
    }
}