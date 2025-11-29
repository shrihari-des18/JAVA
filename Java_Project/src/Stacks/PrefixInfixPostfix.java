package Stacks;

import java.util.Stack;

public class PrefixInfixPostfix {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        int ans = solveInfix(str);
        String I2Po = InfixToPostfix(str);
        String I2Pr = InfixToPrefix(str);
        System.out.println("Infix exp: "+ str);
        System.out.println("Infix ans: " + ans);
        System.out.println("Postfix exp: "+ I2Po);
        System.out.println("Postfix ans: " + solvePostfix(I2Po));
        System.out.println("Prefix exp: "+ I2Pr);
        System.out.println("Prefix ans: "+ solvePrefix(I2Pr));
        System.out.println("Prefix to Postfix: "+ PrefixToPostfix(I2Pr));
        System.out.println("Postfix to Prefix: "+PostfixToPrefix(I2Po));
        System.out.println("Postfix to Infix: "+PostfixToInfix(I2Po));
        System.out.println("Prefix to Infix: "+ PrefixToInfix(I2Pr));
    }

    private static int solveInfix(String str) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
             int ascii = (int) ch;
             if(ascii >= 48 && ascii <= 57) val.push(ascii-48);
             else if (op.isEmpty() || ch == '(' || op.peek() == '(')
                 op.push(ch);
             else if (ch == ')') {
                 while(op.peek() != '('){
                     int v2 = val.pop();
                     int v1 = val.pop();
                     if(op.peek() == '+') val.push(v1+v2);
                     if(op.peek() == '-') val.push(v1-v2);
                     if(op.peek() == '*') val.push(v1*v2);
                     if(op.peek() == '/') val.push(v1/v2);
                     op.pop();
                 }
                 op.pop();
             }
             else{
                 if(ch == '+' || ch == '-'){
                     int v2 = val.pop();
                     int v1 = val.pop();
                     if(op.peek() == '+') val.push(v1+v2);
                     if(op.peek() == '-') val.push(v1-v2);
                     if(op.peek() == '*') val.push(v1*v2);
                     if(op.peek() == '/') val.push(v1/v2);
                     op.pop();
                     op.push(ch);
                 }
                 if(ch == '*' || ch == '/') {
                     if (op.peek() == '*' || op.peek() == '/') {
                         int v2 = val.pop();
                         int v1 = val.pop();
                         if (op.peek() == '*') val.push(v1 * v2);
                         if (op.peek() == '/') val.push(v1 / v2);
                         op.pop();
                         op.push(ch);
                     }
                     else op.push(ch);
                 }
             }
        }
        while(val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek() == '+') val.push(v1 + v2);
            if (op.peek() == '-') val.push(v1 - v2);
            if (op.peek() == '*') val.push(v1 * v2);
            if (op.peek() == '/') val.push(v1 / v2);
            op.pop();
        }
        return val.peek();
    }

    private static String InfixToPrefix(String str) {
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <= 57){
                String s = "" + ch;
                val.push(s);
            }
            else if (op.isEmpty() || ch == '(' || op.peek() == '(')
                op.push(ch);
            else if (ch == ')') {
                while(op.peek() != '('){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);
                }
                op.pop();
            }
            else{
                if(ch == '+' || ch == '-'){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = o + v1 + v2;
                        val.push(t);
                        op.push(ch);
                    }
                    else op.push(ch);
                }
            }
        }
        while(val.size() > 1) {
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = o + v1 + v2;
            val.push(t);
        }
        return val.peek();
    }

    private static String InfixToPostfix(String str) {
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <= 57){
                String s = "" + ch;
                val.push(s);
            }
            else if (op.isEmpty() || ch == '(' || op.peek() == '(')
                op.push(ch);
            else if (ch == ')') {
                while(op.peek() != '('){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    val.push(t);
                }
                op.pop();
            }
            else{
                if(ch == '+' || ch == '-'){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1 + v2 + o;
                    val.push(t);
                    op.push(ch);
                }
                if(ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = v1 + v2 + o;
                        val.push(t);
                        op.push(ch);
                    }
                    else op.push(ch);
                }
            }
        }
        while(val.size() > 1) {
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = v1 + v2 + o;
            val.push(t);
        }
        return val.peek();
    }

    private static int solvePostfix(String str){
        Stack<Integer> val = new Stack<>();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <=57)
                val.push(ascii - 48);
            else {
                int v2 = val.pop();
                int v1 = val.pop();
                if(ch == '+') val.push(v1+v2);
                if(ch == '-') val.push(v1-v2);
                if(ch == '*') val.push(v1*v2);
                if(ch == '/') val.push(v1/v2);
            }
        }
        return val.pop();
    }

    private static int solvePrefix(String str){
        Stack<Integer> val = new Stack<>();

        int n = str.length();
        for (int i = n-1; i >= 0; i--) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <=57)
                val.push(ascii - 48);
            else {
                int v1 = val.pop();
                int v2 = val.pop();
                if(ch == '+') val.push(v1+v2);
                if(ch == '-') val.push(v1-v2);
                if(ch == '*') val.push(v1*v2);
                if(ch == '/') val.push(v1/v2);
            }
        }
        return val.pop();
    }

    private static String PrefixToPostfix(String str){
        Stack<String> val = new Stack<>();

        int n = str.length();
        for (int i = n-1; i >= 0; i--) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <= 57){
                String s = ""+ch;
                val.push(s);
            }
            else{
                String v1 = val.pop();
                String v2 = val.pop();
                val.push(v1+v2+ch);
            }
        }
        return val.pop();
    }

    private static String PostfixToPrefix(String str){
        Stack<String> val = new Stack<>();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <= 57){
                String s = ""+ch;
                val.push(s);
            }
            else{
                String v2 = val.pop();
                String v1 = val.pop();
                val.push(ch+v1+v2);
            }
        }
        return val.pop();
    }

    private static String PostfixToInfix(String str){
        Stack<String> val = new Stack<>();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <= 57){
                String s = ""+ch;
                val.push(s);
            }
            else{
                String v2 = val.pop();
                String v1 = val.pop();
                val.push("("+v1+ch+v2+")");
            }
        }
        return val.pop();
    }

    private static String PrefixToInfix(String str){
        Stack<String> val = new Stack<>();

        int n = str.length();
        for (int i = n-1; i >= 0; i--) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if(ascii >= 48 && ascii <= 57){
                String s = ""+ch;
                val.push(s);
            }
            else{
                String v1 = val.pop();
                String v2 = val.pop();
                val.push("("+v1+ch+v2+")");
            }
        }
        return val.pop();
    }
}
