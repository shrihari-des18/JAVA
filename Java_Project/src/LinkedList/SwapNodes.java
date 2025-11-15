package LinkedList;
class Sl{
    Node head;
    public Node Swap(Node head, int k){
        Node slow = head;
        Node fast = head;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        Node left = fast;

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        int temp = left.val;
        left.val = slow.val;
        slow.val = temp;
        return head;
    }
}

public class SwapNodes {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);

        Sl list1 = new Sl();
        list.head = list1.Swap(list.head,3);
        list.print();
    }
}
