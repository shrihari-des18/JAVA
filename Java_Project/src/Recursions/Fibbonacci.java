package Java_Project.src.Recursions;

public class Fibbonacci {
    public static int fibbonacci(int n){
        if(n <= 1) return n;
        return fibbonacci(n-1) + fibbonacci(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibbonacci(11)); // 0 1 1 2 3 5
    }
}
