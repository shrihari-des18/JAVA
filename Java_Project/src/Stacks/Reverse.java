package Stacks;


import java.util.Stack;
public class Reverse {
    public static void PaB(int data, Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        PaB(data, s);
        s.push(top);
    }

    public static void rev(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }

        int top = s.pop();
        rev(s);
        PaB(top, s);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        rev(s);
        System.out.println(s);
    }
}
