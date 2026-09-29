package Week_6.Day_2;

import java.util.ArrayDeque;
import java.util.Deque;

/*
If asked "How can two stacks implement a queue?", your answer should basically be:

"I use one stack for incoming elements and another for outgoing elements. 
New elements go into the incoming stack. When I need to remove or inspect the front and 
the outgoing stack is empty, I transfer all elements from the incoming stack to the outgoing stack. 
This reverses their order, putting the oldest element on top, which gives FIFO behavior. 
I only transfer when necessary, giving O(1) amortized time for push, pop, and peek."
 */

public class queueUsingStack {
    class MyQueue {
        Deque<Integer> enter = new ArrayDeque<>();
        Deque<Integer> exit = new ArrayDeque<>();

        void push(int x) {
            enter.push(x);
        }

        int pop() {
            if (exit.isEmpty()) {
                while (!enter.isEmpty()) {
                    exit.push(enter.pop());
                }
            }
            return exit.pop();
        }

        int peek() {
            if (exit.isEmpty()) {
                while (!enter.isEmpty()) {
                    exit.push(enter.pop());
                }
            }
            return exit.peek();
        }

        boolean empty() {
            return (enter.isEmpty() && exit.isEmpty());
        }
    }
}