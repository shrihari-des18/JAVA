package Stacks;
import java.util.*;
public class CF {
    public static void displayReverse(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top = s.pop();
        System.out.print(top+" ");
        displayReverse(s);
        s.push(top);
    }
    public static void displayRecursive(Stack<Integer> s){
        if(s.isEmpty()) return;
        int top = s.pop();
        displayRecursive(s);
        System.out.print(top+" ");
        s.push(top);
    }
    public static void pushAtBottom(Stack<Integer> st, int data){
        if (st.isEmpty()){
            st.push(data);
            return;
        }
        int top = st.pop();
        pushAtBottom(st,data);
        st.push(top);
    }
    public static void rev(Stack<Integer> st){
        if(st.size()==1) return;
        int top = st.pop();
        rev(st);
        pushAtBottom(st,top);
    }
    public static void RemoveFromIndex(Stack<Integer> st, int idx){
        Stack<Integer> temp = new Stack<>();
        while(st.size()>idx){
            temp.push(st.pop());
        }
        st.pop();
        while (temp.size()>0) st.push(temp.pop());
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        pushAtBottom(s,6);
        System.out.println(s);
        rev(s);
        System.out.println(s);
        RemoveFromIndex(s,5);
        System.out.println(s);
    }

}
