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
}
class Client {
    public static void main(String[] args) {

        DoubleLinkedList dll = new DoubleLinkedList();

        // Insert at beginning
        dll.addFirst(20);
        dll.addFirst(10);

        // Insert at end
        dll.addLast(30);
        dll.addLast(40);

        // Print the list
        dll.printDLL();
    }
}