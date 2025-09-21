package LinkedList;

class S {
    public Node delete(Node head, int n){
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null) return head.next;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
public class RemoveNthNodeFromLast{
    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);
        S list1 = new S();
        list.head =  list1.delete(list.head,6);
        list.print();
    }
}
