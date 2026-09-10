package Week_5.Day_1;

public class SinglyLinkedListBasics {
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

        void printlist() {
            // traverse the list and print all nodes:
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data);
                System.out.print("\t");
                curr = curr.next;
            }
            System.out.println();
        }

        void addFirst(int data) {
            if (head == null) {
                head = new Node(data);
            }
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void addLast(int data) {
            if (head == null) {
                head = new Node(data);
            }
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            Node newNode = new Node(data);
            curr.next = newNode;
        }

        boolean contains(int target) {
            if (head == null) {
                return false;
            }
            Node curr = head;
            while (curr != null) {
                if (curr.data == target) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        void deleteFirst() {
            if (head == null || head.next == null) {
                head = null;
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        // create Linked list
        Node first = new Node(10);
        Node second = new Node(20);
        first.next = second;
        Node third = new Node(30);
        second.next = third;
        Node fourth = new Node(40);
        third.next = fourth;
        Node fifth = new Node(50);
        fourth.next = fifth;
        LinkList list = new LinkList();
        list.head = first;
        list.printlist();

        list.addFirst(5);
        list.printlist();
        list.addLast(60);
        list.printlist();

        System.out.println("Does linked list contain 20 ?" + list.contains(20));
        list.deleteFirst();
        list.printlist();

    }
}
