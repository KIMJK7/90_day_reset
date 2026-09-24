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
                front.next = prev.next;
                prev.next = front;
            }

            return dummy.next;

        }

        static boolean isPalindrome(Node head) {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // slow is in middle

            // reverse 2nd half
            Node prev = null;
            Node curr = slow;

            while (curr != null) {
                Node front = curr.next;
                curr.next = prev;
                prev = curr;
                curr = front;
            }
            Node first = head;
            Node second = prev;
            while (second != null) {
                if (first.data != second.data) {
                    return false;
                }
                first = first.next;
                second = second.next;
            }

            // retore linked list to original;
            // new head of linked list is stored in prev;
            Node back = null; // first is the end of first half
            curr = prev;
            while (curr != null) {
                Node front = curr.next;
                curr.next = back;
                back = curr;
                curr = front;
            }

            return true;
        }

        // 1->2->3->4->5
        // output 1->5->2->4->3 (first->last->second->second_last->...)
        static void reorderList(Node head) {
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // slow is middle
            // sperate the two halves
            Node second = slow.next;
            slow.next = null;

            Node prev = null;
            Node curr = second;
            while (curr != null) {
                Node front = curr.next;
                curr.next = prev;
                prev = curr;
                curr = front;
            }

            // prev is newhead of reversed linked list
            // merge both linked list
            Node first = head;
            second = prev;
            while (second != null) {
                Node firstNext = first.next;
                Node secondNext = second.next;
                first.next = second;
                second.next = firstNext;
                first = firstNext;
                second = secondNext;
            }
        }
    }
}
