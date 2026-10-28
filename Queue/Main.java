
class Queue {
    int queueArr[];
    int front;                //Points to the first element
    int rear;                //  rear means Points to the last element
    int maxSize;

    // Constructor
    Queue(int size) {
        this.queueArr = new int[size];
        this.front = -1;
        this.rear = -1;
        this.maxSize = size;
    }

    // Insert element into queue
    void enqueue(int data) {
        if (rear == maxSize - 1) {
            System.out.println("Queue is full");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else {
            rear++;
        }

        queueArr[rear] = data;
    }

    // Remove and return first element from queue  
    //dequeuing or a poll operation
    int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        int data = queueArr[front];
        front++;          // eg .....The old array value 10 is not physically erased. It is simply no longer considered part of the active queue.

        // Reset queue when all elements are removed
        if (front > rear) {
            front = rear = -1;
        }

        return data;
    }

    // Display front element without removing it  calles as peek() or front().
    int atfront() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queueArr[front];
    }

    // Display all queue elements
    void printQueue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(queueArr[i] + " ");
        }

        System.out.println();
    }

    // Check whether queue is empty
    boolean empty() {
        return front == -1;
    }
}

// Client class
class Main {
    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Queue elements:");
        q.printQueue();

        System.out.println("Front element: " + q.atfront());

        System.out.println("Removed element: " + q.dequeue());

        System.out.println("Queue after dequeue:");
        q.printQueue();

        System.out.println("Is queue empty? " + q.empty());

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println("Is queue empty? " + q.empty());
    }
}
