package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class InsertElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        for (int i = 1; i <= 5; i++) {
            st.push(i);
        }
        System.out.println(st);
        Stack<Integer> temp = new Stack<>();
        System.out.println("Enter the index: ");
        int n = sc.nextInt();
        while(st.size()>n){
            temp.push(st.pop());
        }
        System.out.println(temp);
        System.out.println("Enter the value: ");
        st.push(sc.nextInt());
        while (!temp.isEmpty()){
            st.push(temp.pop());
        }
        System.out.println(st);
    }
}
