public class DoublyLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;
        
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head=null;
    public static Node tail=null;


    public void addlast(int data){
        Node newnode=new Node(data);
        Node temp=head;
        if(head==null){
            head=newnode;
        }
        else if(head.next==null){
            head.next=newnode;
            newnode.prev=head;
        }
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.prev=temp;


    }
    public void addfirst(int data){
        Node newnode=new Node(data);
        if(head==null ){
            head=newnode;
        }
        
        head.prev=newnode;
        newnode.next=head;
        head=newnode;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList dll=new DoublyLinkedList();
        // dll.addfirst(0);
        // dll.addfirst(97);
        // dll.addfirst(77);
        dll.addlast(0);
        dll.print();
    }
    

}
