
class Queue {

    // Node class represents one element in the linked list
    class Node {
        int data;       // Stores the value of the node
        Node next;      // Stores the address of the next node

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front;         // Points to the first node in the queue
    Node rear;          // Points to the last node in the queue

    // Constructor initializes an empty queue
    Queue() {
        front = null;
        rear = null;
    }

    // Insert an element at the rear of the queue
    void enqueue(int data) {

        // Create a new node for the given data
        Node newNode = new Node(data);

        // If the queue is empty, both front and rear point to the new node
        if (front == null) {
            front = rear = newNode;
        } else {
            // Connect the current rear node to the new node
            rear.next = newNode;

            // Move rear to the newly inserted node
            rear = newNode;
        }
    }

    // Remove and return the element from the front of the queue
    int dequeue() {

        // Check whether the queue is empty
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Store the front node's data before removing it
        int data = front.data;

        // Move front to the next node
        front = front.next;

        // If the queue becomes empty, rear must also become null
        if (front == null) {
            rear = null;
        }

        // Return the removed element
        return data;
    }

    // Return the front element without removing it
    int atfront() {

        // Check whether the queue is empty
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Return the data stored in the front node
        return front.data;
    }

    // Display all elements from front to rear
    void printQueue() {

        // Check whether the queue is empty
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }

        // Start traversing from the front node
        Node temp = front;

        // Visit each node until the end of the linked list
        while (temp != null) {
            System.out.print(temp.data + " ");

            // Move to the next node
            temp = temp.next;
        }

        // Move to the next line after printing all elements
        System.out.println();
    }

    // Check whether the queue is empty
    boolean empty() {
        return front == null;
    }
}

// Client class to test the queue implementation
public class Client1 {
    public static void main(String[] args) {

        // Create an empty queue
        Queue q = new Queue();

        // Insert elements into the queue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        // Display all queue elements
        System.out.println("Queue elements:");
        q.printQueue();

        // Display the front element without removing it
        System.out.println("Front element: " + q.atfront());

        // Remove and display the first element
        System.out.println("Removed element: " + q.dequeue());

        // Display the queue after deletion
        System.out.println("Queue after dequeue:");
        q.printQueue();

        // Check whether the queue is empty
        System.out.println("Is queue empty? " + q.empty());
    }
}
