package Stacks;

import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 8, 7, 2};
        int[] res = previousGreater(arr);
        for(int i : res){
            System.out.print(i+ " ");
        }
    }

    private static int[] previousGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()) res[i] = i+1;
            else res[i] = i-st.peek();
            st.push(i);

        }
        return res;
    }
}
