class Node {
    Node prev =null;
    int data;
    Node next =null;
    Node(int data){
        this.data=data;
    }
}
class DoubleLinkedList{
    Node head =null;

    void addFirst(int data){
        Node newNode = new Node(data);
        if(head ==null){
            head = newNode;
        }else{
            newNode.next =head;               //new node forward point karte first old node la 
            head.prev = newNode;         //1st old node backward point karte to new node 
            head=newNode;                   // head update hoto new node la
        }
    }
    void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        }else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = newNode;
            newNode.prev=temp;
        }
    }
    void printDLL(){
        if(head==null){
            System.out.println("LL is empty");
        }else{
            Node temp =head;
            while(temp.next!=null){
                System.out.print(temp.data + "-->");
                temp =temp.next;
            }
            System.out.println(temp.data);

        }
    }

    int countNode(){
        int count =0;
        if(head ==null){
            return count;
        }else{
            Node temp =head;
            while(temp!=null){
                count++ ;
                temp =temp.next;
            }
            return count;
        }
        
    }

void addAtPos(int pos, int data) {

    if (pos <= 0 || pos > countNode() + 1) {
        System.out.println("Wrong input");
        return;
    }

    if (pos == 1) {
        addFirst(data);
    } else if (pos == countNode() + 1) {
        addLast(data);
    } else {
        Node newNode = new Node(data);
        Node temp = head;

        // Reach the node just before the target position
        while (pos - 2 != 0) {
            temp = temp.next;
            pos--;
        }

        newNode.prev = temp;         //Connect the new node backward
        newNode.next = temp.next;    //Connect the new node forward

        temp.next = newNode;         //Update the previous node's forward link
        newNode.next.prev = newNode;  //Update the next node's backward link
    }
}

void delAtPos(int pos){
    if(pos<=0 ||pos>=countNode()+1){
        System.out.println("wrong input ");
        return ;
    }
    //if position 1 asel tr delte first cha block lihava lagel ani pos =countnode +1 asel tr delte last cha block lihava lagle 
    else{
        Node temp =head;
        while(pos-2!=0){
            temp=temp.next;
            pos-- ;

        }
        temp.next =temp.next.next;   //Skip the node to be deleted
        temp.next.prev=temp;         //Fix the backward link
    }
}
}
class Client1 {
    public static void main(String[] args) {

        DoubleLinkedList dll = new DoubleLinkedList();

        dll.addFirst(20);
        dll.addFirst(10);
        dll.addLast(40);
        dll.addLast(50);

        System.out.println("Original Doubly Linked List:");
        dll.printDLL();

        System.out.println("\nTotal nodes: " + dll.countNode());

        System.out.println("\nInserting 30 at position 3:");
        dll.addAtPos(3, 30);
        dll.printDLL();

        System.out.println("\nTotal nodes: " + dll.countNode());

        System.out.println("\nInserting 5 at position 1:");
        dll.addAtPos(1, 5);
        dll.printDLL();

        System.out.println("\nInserting 60 at the last position:");
        dll.addAtPos(dll.countNode() + 1, 60);
        dll.printDLL();

        System.out.println("\nTrying an invalid position:");
        dll.addAtPos(100, 70);

        System.out.println("\nBefore deletion:");
dll.printDLL();

System.out.println("\nDeleting node at position 3:");
dll.delAtPos(3);
dll.printDLL();

System.out.println("\nTotal nodes after deletion: " + dll.countNode());

System.out.println("\nDeleting first node:");
dll.delAtPos(1);
dll.printDLL();

System.out.println("\nDeleting last node:");
dll.delAtPos(dll.countNode());
dll.printDLL();
    }
}