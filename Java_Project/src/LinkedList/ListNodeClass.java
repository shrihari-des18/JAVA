package LinkedList;

import java.util.Scanner;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}

public class ListNodeClass {
    Scanner sc = new Scanner(System.in);
    public static void print(Node head) {
        Node temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public static void print1(Node head){
        Node temp = head;
        System.out.println(temp.val);
        if(temp.next == null) return;
        print1(temp.next);
    }
    public static void addend(Node head,int val){
        Node temp = new Node(val);
        Node ptr = head;
        while(ptr.next != null){
            ptr = ptr.next;
        }
        ptr.next = temp;
    }
    public static void main(String[] args) {
        Node a = new Node(10);
        addend(a,20);
        addend(a,30);
        addend(a,40);

        print(a);

    }
}
