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

        static boolean isPalindrome(ListNode head) {
            // step 1 find middle
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // slow is at middle of linked list
            // reverse 2nd half of the list
            ListNode prev = null;
            ListNode curr = slow.next;
            while (curr != null) {
                ListNode front = curr.next;
                curr.next = prev;
                prev = curr;
                curr = front;
            }

            // 2nd half of the list is reversed

            ListNode first = head;
            ListNode second = prev;
            while (second != null) {
                if (first.val != second.val) {
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            // reverse the 2nd hald again
            ListNode reversePrev = slow;
            ListNode reverseCurr = prev;
            while (reverseCurr != null) {
                ListNode front = reverseCurr.next;
                reverseCurr.next = reversePrev;
                reversePrev = reverseCurr;
                reverseCurr = front;
            }
            return true;
        }

        public ListNode detectCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            boolean isCycle = false;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    isCycle = true;
                    break;
                }
            }

            if (isCycle == true) {
                slow = head;
                while (fast != null) {
                    if (slow == fast) {
                        return slow;
                    }
                    slow = slow.next;
                    fast = fast.next;

                }
            }
            return null;
        }

        static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;

            return dummy.next;
        }

        static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode pA = headA;
            ListNode pB = headB;
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
    }
}
