public class interview {
    class Node {
        int val;
        Node nxt;

        public Node(int v, Node n) {
            val = v;
            nxt = n;
        }
    }

    public Node reverseLL(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.nxt;
            curr.nxt = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        interview obj = new interview();
        Node head = obj.new Node(1, null);
        head.nxt = obj.new Node(2, null);
        head.nxt.nxt = obj.new Node(3, null);
        head.nxt.nxt.nxt = obj.new Node(4, null);
        head.nxt.nxt.nxt.nxt = obj.new Node(5, null);
        System.out.println("Original Linked List:");
        Node newHead = obj.reverseLL(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.nxt;
        }
    }
}
