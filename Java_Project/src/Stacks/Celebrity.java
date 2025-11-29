package Stacks;

import java.util.Stack;

public class Celebrity {
    public static void main(String[] args) {
        int[][] m = {
                {1,1,0,0},
                {0,1,0,0},
                {0,1,1,0},
                {0,1,0,1}
        };
        System.out.println(celeb1(m));

    }
    private static int celeb(int[][] M){
        int n = M.length;
        int cel = -1;
        int cel_c = 0;
        boolean ch;
        for (int i = 0; i < n; i++) {
            ch = true;
            for (int j = 0; j < n; j++) {
                if (i != j && M[i][j] == 1) {
                    ch = false;
                    break;
                }
            }
            if(ch) {
                cel = i;
                cel_c++;
            }
        }
        if(cel == -1) return cel;
        if(cel_c > 1) return -1;

        ch = true;
        for (int i = 0; i < n; i++) {
            if (i != cel && M[i][cel] == 0) {
                ch = false;
                break;
            }
        }
        if(!ch) return -1;
        return cel;
    }

    private static int celeb1(int[][] M){
        Stack<Integer> st = new Stack<>();
        int n = M.length;

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while(st.size() > 1){
            int v1 = st.pop();
            int v2 = st.pop();
            if(M[v1][v2] == 0) st.push(v1);
            else if (M[v2][v1] == 0) st.push(v2);
        }
        if(st.isEmpty()) return -1;
        int cel = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != cel && M[cel][i] == 1) return -1;
        }
        for (int i = 0; i < n; i++) {
            if(i != cel && M[i][cel] == 0) return -1;
        }
        return cel;
    }
}
