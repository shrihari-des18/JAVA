package Random_;

public class XPowerN {
     static double fn(int x, int n){

        int b = n;
        double a = 1;

        while(b>0){
            if(b % 2 == 1){
                a *= x;
            }
            b/=2;
            x*=x;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fn(2,10));

    }

}
