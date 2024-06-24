public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node Head;
    public static Node Tail;
    public static int count;

    public  void addfirst(int data){
        if(Head==null){
            Node newnode=new Node(data);
            Head=Tail=newnode;
            return;
        }
        Node newnode=new Node(data);
        count++;
        newnode.next=Head;
        Head=newnode;
    }

    public  void addLast(int data){
        if(Head==null){
            Node newnode=new Node(data);
            Head=Tail=newnode;
            return;
        }
        Node newNode=new Node(data);
        count++;
        Tail.next=newNode;
        Tail=newNode;
    }
    
    
    public void print(){
        if(Head==null){
            System.out.println("The Linked List is Empty!!");
            return;
        }
        Node temp=Head;
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }
        System.out.println();
    }

    public void addAt(int index,int data){
        if(index==0){
            addfirst(data);
            return;
        }
        Node newnNode=new Node(data);
        count++;
        Node temp=Head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newnNode.next=temp.next;//newnode ka pointer joh abhi tak null thawoh ab temp.next yaanielement at i ko point karta hai
        temp.next=newnNode;
        
    }
    public int removefirst(){
        if(count==0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        }
        else if(count==1){
            int value=Head.data;
            Head=Tail=null;
            count=0;
            return value;
        }
        int value=Head.data;
        count--;
        Head=Head.next;
        return value;
    }

    public int removelast(){
        if(count==0){
            System.out.println("The list is empty!!");
            return Integer.MIN_VALUE;
        }
        else if(count==1){
            int val=Head.data;
            Head=Tail=null;
            count=0;
            return val;
        }
        // int i=0;
        Node temp=Head;
        for(int i=0;i<count-2;i++){
            temp=temp.next;
        }
        int val=temp.next.data;
        temp.next=null;
        Tail=temp;
        count--;
        return val;
    }

    public int search(int target){
        Node temp=Head;
        int i=0;
        while(temp!=null){
            if(temp.data==target){
                return i;
            }
            i++;
            temp=temp.next;
        }
        return -1;
    }
    public int helper(int target,Node Head){
        if(Head==null){
            return -1;
        }
        if(Head.data==target){
            return 0;
        }
        int index=helper(target, Head.next);
        if(index==-1){
            return -1;
        }
        return index+1;
    }

    public int searchRecursive(int target){
        return helper(target, Head);
    }

    public void deleteLastNthElement(int n){
        int size=0;
        Node temp=Head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }

        if(size==n){
            Head=Head.next;
            return;
        }

        int index=size-n;
        if(n==1){
            Node temp2=Head;
            for(int i=0;i<index-1;i++){
                temp2=temp2.next;
            }
            temp2.next=null;
            return;
        }
        Node prev=Head;
        for(int i=0;i<index-1;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return;
    }
    public boolean isCycle(){
        Node slow=Head;
        Node fast=Head;
        while(fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    public void removecycle(){
        //Detect Cycle
        Node slow=Head;
        Node fast=Head;
        boolean flag=false;
        while(fast.next!=null && fast!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                flag=true;
                break;
            }
        }
        Node prev=fast;
        if(flag==false){
            return;
        }
        slow=Head;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
        return;
    }

    public static Node isMid(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static Node merge(Node head1,Node head2){
        Node temp=new Node(-1);
        Node MergedLL=temp;
        while(head1!=null && head2!=null){
            if(head1.data>head2.data){
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
            else{
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
        }

        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }

        return MergedLL.next;
    }

    public static Node mergesort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node middle=isMid(head);
        Node righthead=middle.next;
        middle.next=null;
        Node leftnode=mergesort(head);
        Node rightnode=mergesort(righthead);
        return merge(leftnode,rightnode);

    }
    public static void Zigzag(Node Head){
        Node mid=isMid(Head);
        Node prev=null,curr=mid.next,next;
        mid.next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node righthead=prev,lefthead=Head;
        Node nextH,nextT;
        while(righthead!=null && lefthead!=null){
            nextH=lefthead.next;
            nextT=righthead.next;
            lefthead.next=righthead;
            righthead.next=nextH;
            lefthead=nextH;
            righthead=nextT;
        }
    }
    /* */
    public void intersectionat(Node head1,Node head2){
        Node temp1=head1,temp2=head2;
        while(temp1!=null && temp2!=null){
            if(temp1.next==temp2.next){
                System.out.println(temp1.data);
            }
        }
    }
    public void deleteafter(Node head,int m,int n){
        Node temp1=head;
        Node temp2=head;
        Node temp3=head;
        while(temp3!=null){
            temp1=temp2=temp3;
            for(int i=0;i<m-1;i++){
                temp1=temp1.next;
            }
            for(int j=0;j<m+n-1;j++){
                temp2=temp2.next;
            }
            temp3=temp2.next;
            temp1.next=temp3;
            temp2.next=null;
        }
    }
    public void printevenfirst(){
        Node temp=Head;
        while(temp!=null){
            if(temp.data%2==0){
                System.out.print(temp.data+"->");
                
            }
            temp=temp.next;
        }
        temp=Head;
        while(temp!=null){
            if(temp.data%2!=0){
                System.out.print(temp.data+"->");
                
            }
            temp=temp.next;
        }

    }
    public void swap(int m,int n){
        Node temp1=Head,temp2=Head;
        for(int i=0;i<m-1;i++){
            temp1=temp1.next;
        }
        for(int j=0;j<n-1;j++){
            temp2=temp2.next;
        }
        Node next1=temp1.next;
        Node next2=temp2.next;
        Node next3=temp1.next.next;
        Node next4=temp2.next.next;

        temp1.next=next2;
        temp2.next=next1;
        next2.next=next3;
        next1.next=next4;


    }
    
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        
        ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.addLast(7);
        // ll.addLast(8);
        // ll.addLast(9);
        // ll.addLast(10);
        ll.print();
        ll.swap(2, 4);
        System.out.println();
        ll.print();
        ll.printevenfirst();
        
        
    }
}
