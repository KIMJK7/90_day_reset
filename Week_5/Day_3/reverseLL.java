package Week_5.Day_3;

public class reverseLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkList {
        Node head;

        Node reverse(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            Node prev = null;
            Node curr = head;
            Node front;
            while (curr != null) {
                front = curr.next;
                curr.next = prev;
                prev = curr;
                curr = front;
            }
            return prev;
        }

        Node reverseRecursive(Node head) {
            if (head == null || head.next == null) {
                return head;
            }
            Node newHead = reverseRecursive(head.next);
            Node front = head.next;
            front.next = head;
            head.next = null;
            return newHead;
        }

        Node reverseBetween(Node head, int left, int right) {
            Node dummy = new Node(0);
            dummy.next = head;

            Node prev = dummy;
            for (int i = 0; i < left; i++) {
                prev = prev.next;
            }

            Node curr = prev.next;

            for (int i = 0; i < right - left; i++) {
                Node front = curr.next;
                curr.next = front.next;
                front.next = curr;
                curr = front;
            }

            return head;

        }
    }
}
