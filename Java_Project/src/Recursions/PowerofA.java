package Java_Project.src.Recursions;

public class PowerofA {
    public static long pow(int a, int b){
        if(b==0) return 1;
        return a * pow(a, b-1);
    }
    public static long pow2(int a, int b){
        if(b==0) return 1;
        long ans = pow2(a,b/2);
        if(b % 2 == 0) return ans * ans;
        else return ans * ans * a;
    }
    public static void main(String[] args) {
        System.out.println(pow2(2,50));
    }
}
