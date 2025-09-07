package LinkedList;
class SLL{
    Node head;
    Node tail;
    int size = 0;

    void insertAtTail(int val){
        Node temp = new Node(val);
        size++;
        if(head == null) head = tail = temp;
        else{
            tail.next = temp;
            tail = temp;
        }
    }

    void insertAtHead(int val){
        Node temp = new Node(val);
        size++;
        if(head == null) head = tail = temp;
        else {
            temp.next = head;
            head = temp;
        }
    }

    void insert(int idx, int val){
        if(idx > size  || idx < 0){
            System.out.println("Invalid index");
            return;
        }
        if(idx == 0) {
            insertAtHead(val);
            return;
        }
        Node temp = new Node(val);
        size++;
        Node cur = head;

        while(idx != 1){
            cur = cur.next;
            idx--;
        }
        temp.next = cur.next;
        cur.next = temp;
    }

    int get(int idx){
        if(idx > size-1 || idx < 0){
            throw new IndexOutOfBoundsException("Index " + idx + " is invalid");
        }
        Node ptr = head;
        for (int i = 0; i < idx && ptr != null; i++) {
            ptr = ptr.next;
        }
        return ptr.val;
    }

    void set(int idx, int val){
        if(idx > size-1 || idx < 0){
            throw new IndexOutOfBoundsException("Index " + idx + " is invalid");
        }
        Node ptr = head;
        for (int i = 0; i < idx && ptr != null; i++) {
            ptr = ptr.next;
        }
        ptr.val = val;
    }

    void print(){
        Node ptr = head;
        while (ptr != null){
            System.out.print(ptr.val+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void deleteAtHead(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    void deleteAtTail(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node ptr = head;
        while(ptr.next.next != null){
            ptr = ptr.next;
        }
        ptr.next = null;
        size--;
        tail = ptr;
    }

    void delete(int idx){
        if (head == null){
            System.out.println("List empty");
            return;
        }

        if(idx > size - 1 || idx < 0){
            System.out.println("Invalid index");
            return;
        }

        if(idx == 0){
            deleteAtHead();
            return;
        }

        Node ptr =head;
        while(idx != 1){
            ptr = ptr.next;
            idx--;
        }
        ptr.next = ptr.next.next;
        size--;
        if(ptr.next == tail) tail = ptr;
    }
}
public class Singly {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtHead(5);
        list.insertAtTail(50);
        list.insert(2,100);

        try{
            System.out.println("- "+ list.get(2));
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try{
            list.set(4,15);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        list.print();
        list.deleteAtTail();

        list.delete(2);
        list.print();
        System.out.println("size - " + list.size);
        System.out.println(list.tail.val);
    }
}
