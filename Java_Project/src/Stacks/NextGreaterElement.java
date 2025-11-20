package Stacks;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,1,6,3,4};
        int[] res = nextGreater(arr);
        for(int i : res){
            System.out.print(i+ " ");
        }
    }

    private static int[] nextGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        res[n - 1] = -1;
        for (int i = n-2; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i])
                st.pop();
            if(st.isEmpty()) res[i] = -1;
            else res[i] = st.peek();
            st.push(arr[i]);
        }
        return res;
    }
}
