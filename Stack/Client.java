
class Stack {
    int[] arr;
    int top;
    int capacity;

    Stack(int size) {
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }

    // Insert an element
    void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }

        top++;
        arr[top] = data;
    }

    // Remove the top element
    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }

        int removedData = arr[top];
        top--;

        return removedData;
    }

    // View the top element
    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return arr[top];
    }


    int size() {
    return top + 1;
}

    // Display the stack from top to bottom
    void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    boolean isEmpty() {
        return top == -1;
    }
}

class Ckient {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack elements:");
        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Removed element: " + stack.pop());
 
        System.out.println("Stack after pop:");
        stack.display();
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
    }
}
