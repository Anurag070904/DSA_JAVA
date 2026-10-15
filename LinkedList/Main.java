
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    public static void main(String[] args) {

        // Creating nodes
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Connecting nodes
        first.next = second;
        second.next = third;

        // Head points to the first node
        Node head = first;

        // Printing the linked list
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
}
