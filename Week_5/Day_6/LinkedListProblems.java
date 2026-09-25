package Week_5.Day_6;

public class LinkedListProblems {
    public class ListNode {
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

        public ListNode deleteDuplicates(ListNode head) {
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
    }
}
