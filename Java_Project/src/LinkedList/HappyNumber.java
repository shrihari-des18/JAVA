package LinkedList;

public class HappyNumber {
    public static boolean isHappy(int n) {
        int ans = 0;
        int x = 0;
        while (ans != 1) {
            while (x > 0) {
                x = digit(n);
                ans = x*x;

            }
            System.out.println(ans);
        }
        if(ans == 1) return true;
        return false;
    }
    public static int digit(int n){
        int a = n % 10;
        n/=10;
        return a;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
