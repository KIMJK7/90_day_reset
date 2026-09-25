package Week_5.Day_6;

public class LinkedListProblems {
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

    static class LinkList {
        ListNode head;

        ListNode deleteDuplicates() {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null) {
                if (slow.val == fast.val) {
                    if (fast.next == null) {
                        slow.next = null;
                        return head;
                    } else {
                        fast = fast.next;
                    }

                } else {
                    slow.next = fast;
                    slow = fast;
                    fast = fast.next;
                }
            }
            return head;
        }

        ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            ListNode prev = dummy;
            ListNode curr = head;

            while (curr != null) {
                if (curr.next != null && curr.val == curr.next.val) {
                    while (curr.next != null && curr.val == curr.next.val) {
                        curr = curr.next;
                    }
                    prev.next = curr.next;
                    curr = curr.next;
                } else {
                    prev = curr;
                    curr = curr.next;
                }

            }
            return dummy.next;
        }
    }
}
