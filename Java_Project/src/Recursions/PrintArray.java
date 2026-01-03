package Java_Project.src.Recursions;

public class PrintArray {
    public static void print(int[] arr,int n){
        if(n <= 0) return;
        print(arr, n-1);
        System.out.println(arr[n-1]);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        print(arr,arr.length);
    }
}
