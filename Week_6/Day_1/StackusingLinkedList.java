package Week_6.Day_1;

public class StackusingLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Stack {
        ListNode head;

        public static void push(ListNode head, int x) {
            // elemnet added to front of list
            ListNode newNode = new ListNode(x);
            newNode.next = head;
            head = newNode;
        }

        public static ListNode pop(ListNode head) {
            ListNode poped = head;
            head = head.next;
            return poped;
        }

        public static ListNode peek(ListNode head) {
            ListNode top = head;
            return top;
        }

        public static boolean isEmpty(ListNode head) {
            if (head == null) {
                return true;
            }
            return false;
        }

        public static int size(ListNode head) {
            if (head == null) {
                return 0;
            }
            int length = 0;
            ListNode temp = head;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            return length;
        }

    }

    class MyStack {

        int[] data = new int[5];
        int top = 0;

        void push(int value) {
            if (top == data.length) {
                System.out.println("Stack Overflow");
                return;
            }

            data[top] = value;
            top++;
        }

        int pop() {
            if (top == 0) {
                System.out.println("Stack Underflow");
                return -1;
            }

            top--;
            return data[top];
        }

        int peek() {
            if (top == 0) {
                System.out.println("Stack is empty");
                return -1;
            }

            return data[top - 1];
        }
    }
}
