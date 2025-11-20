package Stacks;

import java.util.Stack;

public class ReverseOrder {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 5; i++) {
            st.push(i);
        }
        System.out.println(st);
        Stack<Integer> rt = new Stack<>();
        while (!st.isEmpty()){
            rt.push(st.pop());
        }
        System.out.println(rt);
    }
}
