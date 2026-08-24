package Week_3.Day_6;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

/*
Input
["MyQueue","push","push","peek","pop","empty"]
[[],[1],[2],[],[],[]]
Output
[null,null,null,1,1,false]
Expected
[null,null,null,1,1,false]
 */

import java.util.Stack;

public class queueUsingStack {
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();

    public queueUsingStack() {

    }

    public void push(int x) {
        input.push(x);
    }

    private void moveInputToOutput() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public int pop() {
        moveInputToOutput();
        return output.pop();
    }

    public int peek() {
        moveInputToOutput();
        return output.peek();
    }

    public boolean empty() {
        return (input.isEmpty() && output.isEmpty());
    }

}
