public class alinkedlist {
    public static class Node {
        int val;
        Node next;

        public Node(int v) {
            val = v;
        }

        public Node(int v, Node n) {
            val = v;
            next = n;
        }
    }

    public static Node createList(int nums[]) {
        if (nums == null || nums.length == 0)
            return null;

        Node head = new Node(nums[0]);

        Node temp= head;

        for (int i = 1; i < nums.length; i++) {
            temp.next = new Node(nums[i]);
            temp = temp.next;
        }

        return head;
    }

    public static void print(Node head){
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.val+"    ");
            temp = temp.next;
        }
        System.out.println();

        return;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node curr = slow, prev = null;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head, right = prev;
        while (left != null && right != null && left != right) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static void removeNthFromEnd(Node head , int n){
        Node dummy = new Node(0,head);
        
        Node slow = dummy;
        Node fast = dummy;

        for(int i = 0;i<=n;i++){
            fast=fast.next;
        }

        while (fast!=null) {
            slow = slow.next;
            fast= fast.next;
        }

        slow.next = slow.next.next;

        return;
    }

    public static void main(String[] args) {
        int num[] = {2,3,4,4,3,2};
        Node head = createList(num);

        print(head);

        removeNthFromEnd(head, 1);

        print(head);

        System.out.println(isPalindrome(head));
    }
}
