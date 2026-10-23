
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

    // Add a node at a specific position (0-based)
    void addAtPosition(int data, int position) {

        if (position < 0) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(data);

        // Insert at the beginning
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;

        // Reach the node just before the target position
        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid position!");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete a node at a specific position (0-based)
    void deleteAtPosition(int position) {

        if (head == null || position < 0) {
            System.out.println("Invalid position or empty list!");
            return;
        }

        // Delete the first node
        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;

        // Reach the node just before the target position
        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Invalid position!");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Invalid position!");
            return;
        }

        // Skip the node to be deleted
        temp.next = temp.next.next;
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

public class Position {
    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();

        list.addAtPosition(10, 0);
        list.addAtPosition(20, 1);
        list.addAtPosition(40, 2);

        System.out.println("Original Linked List:");
        list.printList();

        list.addAtPosition(30, 2);

        System.out.println("After adding 30 at position 2:");
        list.printList();

        list.deleteAtPosition(1);

        System.out.println("After deleting position 1:");
        list.printList();
    }
}
