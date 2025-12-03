package Queue;

import java.util.LinkedList;

class QueueArray {
    private int f = -1;
    private int r = -1;
    private final int[] arr = new int[100];
    int size = 0;

    public void add(int val){
        if(r == arr.length-1){
            System.out.println("Queue full!");
            return;
        }
        size++;
        if(f == -1) {
            f=r=0;
            arr[r] = val;
        }
        else{
            arr[++r] = val;
        }
    }

    public int remove(){
        if(size == 0) {
            System.out.println("Queue Empty!");
            return -1;
        }
        size--;
        f++;
        return arr[f-1];
    }

    public int peek(){
        if(size == 0) {
            System.out.println("Queue Empty!");
            return -1;
        }
        return arr[f];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if(size == 0) {
            System.out.println("Queue Empty!");
            return;
        }
        for (int i = f; i <= r; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

class QueueLL{
    LinkedList<Integer> l = new LinkedList<>();
    int size = 0;

    public void add(int val){
        l.add(val);
        size++;
    }

    public int remove(){
        if(l.isEmpty()){
            System.out.println("Queue Empty");
            return -1;
        }
        size--;
        int val = l.getFirst();
        l.removeFirst();
        return val;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int peek(){
        return l.getFirst();
    }

    public void display(){
        for(int i = 0; i < size; i++){
            System.out.print(l.get(i)+ " ");
        }
        System.out.println();
    }
}

class CQueue{
    private int f = -1;
    private int r = -1;
    int size = 0;
    private final int[] arr = new int[5];
    private final int n = arr.length;

    void add(int val) throws Exception{
        if(size == n)
            throw new Exception("Queue is full!");
        else if(size == 0)
            f = r = 0;
        else r = (r+1) % n;
        arr[r] = val;
        size++;
    }

    int remove() throws Exception{
        if(size == 0) throw new Exception("Queue empty!");
        int val = arr[f];
        size--;

        if(size == 0) {
            f = r = -1;
        } else {
            if(f == n-1) f = 0;
            else f++;
        }
        return val;
    }

    boolean isEmpty(){
        return size == 0;
    }

    int peek()throws Exception {
        if (size == 0) throw new Exception("Queue empty!");
        return arr[f];
    }

    void display(){
        if(size == 0) {
            System.out.println("Queue Empty");
            return;
        } else if (f <= r) {
            for (int i = f; i <= r; i++) {
                System.out.print(arr[i]+" ");
            }
        }
        else {
            for (int i = f; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            for (int i = 0; i <= r ; i++) {
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}

public class Implementation {
    public static void main(String[] args) throws Exception {
//        QueueArray ql = new QueueArray();
//        QueueLL ql = new QueueLL();
        CQueue ql = new CQueue();
        for (int i = 0; i < 5; i++) {
            ql.add(i+1);
        }
        ql.display();
        System.out.println(ql.remove());
        ql.add(6);
//        ql.add(7);
        System.out.println(ql.peek());
        ql.display();
    }
}
