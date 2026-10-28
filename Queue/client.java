
//A Circular Queue is a queue in which the last position is connected back to the first position. It follows FIFO (First In, First Out), just like a normal queue.

//The main advantage is that it can reuse empty array positions after elements are removed

class Queue {
    int queueArr[];
    int front;
    int rear;
    int maxSize;

    // Constructor
    Queue(int size) {
        this.queueArr = new int[size];
        this.front = -1;
        this.rear = -1;
        this.maxSize = size;
    }

    // Insert element
    void enqueue(int data) {  
        //checks whether the queue is full.
        if ((rear + 1) % maxSize == front) {     
            System.out.println("Queue is full");
            return;
        }
       //checks whether this is the first insertion.
        if (front == -1) {
            front = rear = 0;
        }
        //moves the rear forward and wraps it back to index 0 when needed.
        else {
            rear = (rear + 1) % maxSize;
        }

        queueArr[rear] = data;
    }

    // Remove element
    int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        int data = queueArr[front];

        if (front == rear) {      //Check whether this is the last element....If front and rear are equal, only one element remains
            front = rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }

        return data;
    }

    // Display front element
    int atfront() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return queueArr[front];
        }
    }

    // Display queue elements
    void printQueue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        int i = front;

        while (true) {
            System.out.print(queueArr[i] + " ");

            if (i == rear) {
                break;
            }

            i = (i + 1) % maxSize;
        }

        System.out.println();
    }

    // Check whether queue is empty
    boolean empty() {
        return front == -1;
    }
}

// Client class
 class Client {
    public static void main(String[] args) {

        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        System.out.println("Original queue:");
        q.printQueue();

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        System.out.println("Queue after dequeue:");
        q.printQueue();

        q.enqueue(60);
        q.enqueue(70);

        System.out.println("Queue after inserting 60 and 70:");
        q.printQueue();

        System.out.println("Front element: " + q.atfront());
        System.out.println("Is queue empty? " + q.empty());
    }
}
