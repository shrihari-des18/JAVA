package Java_Project.src.Recursions;

public class MazePath {
    public static int maze(int r, int c, int m, int n){
        if(r == m || c == n) return 1;
        int rw = maze(r,c+1,m,n);
        int dw = maze(r+1,c,m,n);
        return rw+dw;
    }
    public static int maze2(int m, int n){
        if(m == 1 || n == 1) return 1;
        int rw = maze2(m,n-1);
        int dw = maze2(m-1,n);
        return rw+dw;
    }

    public static void main(String[] args) {
        System.out.println(maze2(3,3));
    }
}
