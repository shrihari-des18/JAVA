package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    //Brute Force - O(n^2)
    private static int[] sol(int[] nums, int k){
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int x = 0;
        for (int i = 0; i < n-k+1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                max = Math.max(max,nums[j]);
            }
            ans[x++] = max;
        }
        return ans;
    }

    private static int[] maxSlidingWindow(int[] nums, int k){
        int n = nums.length;
        int[] ans  = new int[n-k+1];
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n - 1] = n;
        st.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while(!st.isEmpty() && nums[i] > nums[st.peek()])
                st.pop();
            if(st.isEmpty()) nge[i] = n;
            else nge[i] = st.peek();
            st.push(i);
        }
        int x = 0, j = 0;
        for (int i = 0; i < n-k+1; i++) {
            if(j >= i+k) j = i;
            int max = nums[j];
            while(j<i+k){
                max = nums[j];
                j = nge[j];
            }
            ans[x++] = max;
        }
        return ans;
    }
}
