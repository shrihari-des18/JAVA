package Stacks;
class arrayStack{
    int idx = 0;
    int[] arr = new int[10];
    void push(int data){
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        arr[++idx] = data;
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack Overflow");
            return -1;
        }
        return (arr[idx]);
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack Overflow");
            return -1;
        }
        return arr[idx--];
    }
    void display(){
        for (int i = idx; i > 0; i--) {
            System.out.print(arr[i]+" ");
        }
    }
    int size(){
        return idx;
    }
    boolean isEmpty(){
        return size() == 0;
    }
    boolean isFull(){
        return size() == arr.length;
    }
}
public class ArrayImplementation {
    public static void main(String[] args) {
        arrayStack s = new arrayStack();
        for (int i = 0; i < 5; i++) {
            s.push(i);
        }
        System.out.println("size: "+s.size());
        s.display();
    }
}
