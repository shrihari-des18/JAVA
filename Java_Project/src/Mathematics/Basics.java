package Mathematics;

import java.util.Arrays;

public class Basics {
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        return (a * gcd(a,b))/b;
    }

    public static boolean isPrime(int n){
        if(n <= 1) return false;

        for (int i = 2; i*i <= n ; i++) {
            if(n*i == 0)return false;
        }
        return true;
    }

    public static void sieveOfEratosthenes(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p*p <= n; p++) {
            if(isPrime[p]){
                for (int i = p*p; i <= n; i+=p) {
                    isPrime[i] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if(isPrime[i]) System.out.print(i+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        sieveOfEratosthenes(50);
    }
}
