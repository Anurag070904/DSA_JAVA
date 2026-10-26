class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top = null;

    // Insert element
    void push(int data) {
        Node newNode = new Node(data);

        newNode.next = top;                  //The new node points to the previous top node.
        top = newNode;                       //Move top to the new node.
    }

    // Remove top element
    int pop() {
        if (top == null) {
            System.out.println("Stack Underflow!");
            return -1;
        }

        int removedData = top.data;
        top = top.next;

        return removedData;
    }

    // View top element
    int peek() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return top.data;
    }

    // Display stack
    void display() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return;
        }

        Node temp = top;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    boolean isEmpty() {
        return top == null;
    }
}

class Main{
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack elements:");
        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Removed: " + stack.pop());

        System.out.println("Stack after pop:");
        stack.display();
    }
}