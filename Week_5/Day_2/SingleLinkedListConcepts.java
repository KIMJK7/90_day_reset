package Week_5.Day_2;

public class SingleLinkedListConcepts {
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

        void addFirst(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void addAtIndex(int index, int data) {
            if (index == 0) {
                addFirst(data);
                return;
            }
            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                if (previous.next != null) {
                    previous = previous.next;
                } else {
                    return;
                }
            }

            Node newNode = new Node(data);
            newNode.next = previous.next;
            previous.next = newNode;
        }

        void deleteAtIndex(int index) {
            if (index == 0) {
                head = head.next;
            }
            Node previous = head;
            for (int i = 0; i < index - 1; i++) {
                if (previous.next != null) {
                    previous = previous.next;
                } else {
                    return;
                }
            }
            previous.next = previous.next.next;
        }

        int get(int index) {
            if (head == null) {
                return -1;
            }
            Node curr = head;
            for (int i = 0; i < index; i++) {
                if (curr.next != null) {
                    curr = curr.next;
                } else {
                    return -1;
                }
            }
            return curr.data;
        }
    }
}
