package Recursions;
import java.util.Scanner;
public class Nto1 {
    public static void printnto1(int n){
        if(n!=0){
            System.out.println(n);
            printnto1(n - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n");
        int n = sc.nextInt();
        printnto1(n);
    }
}
