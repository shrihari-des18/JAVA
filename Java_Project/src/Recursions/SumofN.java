package Java_Project.src.Recursions;

public class SumofN {
    public static void Sum(int n, int s){
        if(n == 0) {
            System.out.println(s);
            return;
        }
        Sum(n-1, s+n);
    }
    public static void main(String[] args) {
        Sum(100,0);
    }
}
