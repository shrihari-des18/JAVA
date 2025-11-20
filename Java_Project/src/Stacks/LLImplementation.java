package Stacks;
class LLNode{
    int val;
    LLNode next;

    LLNode(int val) {
        this.val = val;
    }
}
class LLStack{
    LLNode head = null;
    int size = 0;

    void push(int x){
        LLNode temp = new LLNode(x);
        temp.next = head;
        head = temp;
        size++;
    }
    int pop(){
        if(head == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        int top = head.val;
        head = head.next;
        return top;
    }
    int peek(){
        if(head == null){
            System.out.println("Stack Underflow");
            return -1;
        }
        return head.val;
    }
    void display(){
        LLNode temp = head;
        while(temp != null){
            System.out.println(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    int size(){
        return size;
    }
}
public class LLImplementation {
    public static void main(String[] args) {
        LLStack s = new LLStack();
        for (int i = 0; i < 8; i++) {
            s.push(i);
        }
        System.out.println("size: "+s.size());
        System.out.println("peeking: "+s.peek());
        s.display();
    }
}