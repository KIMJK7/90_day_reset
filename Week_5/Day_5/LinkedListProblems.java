package Week_5.Day_5;

public class LinkedListProblems {
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

        // two pass method
        Node removeNthNodeEnd(int n) {
            Node dummy = new Node(0);
            dummy.next = head;
            int length = 0;
            Node temp = dummy;
            while (temp != null) {
                length++;
                temp = temp.next;
            }
            int var = length - n - 1;
            Node remove = dummy;
            for (int i = 0; i < var; i++) {
                remove = remove.next;
            }
            remove.next = remove.next.next;
            return dummy.next;
        }

        // one pass method using slow and fast pointers
        Node removeNthFromEnd(int n) {
            Node dummy = new Node(0);
            dummy.next = head;
            Node slow = dummy;
            Node fast = dummy;
            for (int i = 0; i < n + 1; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;

            return dummy.next;
        }

        static Node getIntersectionNode(Node headA, Node headB) {
            Node pA = headA;
            Node pB = headB;
            while (pA != pB) {
                if (pA == null) {
                    pA = headB;
                } else {
                    pA = pA.next;
                }
                if (pB == null) {
                    pB = headA;
                } else {
                    pB = pB.next;
                }
            }
            return pA;
        }

        Node deleteMiddle() {
            if (head == null || head.next == null) {
                return null;
            }
            Node slow = head;
            Node fast = head.next.next;
            while (fast != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow.next = slow.next.next;

            return head;
        }

        Node reverseBetween(int left, int right) {
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

        Node reverseKGroup(int k) {
            if (head == null || k == 1) {
                return head;
            }

            Node curr = head;

            Node lastListElment = null;

            while (curr != null) {
                Node end = curr;
                // find the kth node
                for (int i = 1; i < k; i++) {
                    end = end.next;
                    if (end == null) {
                        // list is less than k elements
                        if (lastListElment != null) {
                            lastListElment.next = curr;
                        }

                        return head;
                    }
                }

                Node nextList = end.next;
                end.next = null;
                Node prev = null;
                Node groupTail = curr;
                while (curr != null) {
                    Node front = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = front;
                }
                if (lastListElment == null) {
                    head = prev;
                } else {
                    lastListElment.next = prev;
                }
                lastListElment = groupTail;
                curr = nextList;

            }

            return head;
        }
    }
}
