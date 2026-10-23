
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;

    // Delete the first node
    void deleteFirst() {
        if (head == null) {
            System.out.println("Linked List is empty!");
            return;
        }

        head = head.next;
    }

    // Delete the last node
    void deleteLast() {
        if (head == null) {
            System.out.println("Linked List is empty!");
            return;
        }

        // If there is only one node
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        // Reach the second-last node
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // Disconnect the last node
        temp.next = null;
    }

    // Print the linked list
    void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}

public class Delete {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        // Create the linked list
        list.head = new Node(10);
        list.head.next = new Node(20);
        list.head.next.next = new Node(30);
        list.head.next.next.next = new Node(40);

        System.out.println("Original Linked List:");
        list.printList();

        list.deleteFirst();
        System.out.println("After deleting first:");
        list.printList();

        list.deleteLast();
        System.out.println("After deleting last:");
        list.printList();
    }
}
