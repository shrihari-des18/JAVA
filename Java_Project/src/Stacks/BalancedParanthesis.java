package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = sc.nextLine();
        System.out.println(isBalanced(str));
    }

    private static boolean isBalanced(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if(ch == '(' ||ch == '[' ||ch == '{') st.push(ch);
            else{
                if(st.isEmpty()) return false;
                char a = st.peek();
                if((a == '(' && ch == ')')
                ||(a == '[' && ch == ']')
                ||(a == '{' && ch == '}')) st.pop();
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}
