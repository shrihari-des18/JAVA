package Java_Project.src.Recursions;

public class NthStair {
    public static int stair(int n){
        if(n <= 2) return n;
        return stair(n-1) + stair(n-2);
    }
    public static void main(String[] args) {
        System.out.println(stair(5));
    }
}
