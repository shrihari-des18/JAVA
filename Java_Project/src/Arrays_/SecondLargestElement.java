package Arrays_;

import java.util.Scanner;

public class SecondLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;

        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if (arr[i]>mx) mx=arr[i];
        }
        int smx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            if (arr[i]!=mx)
                if(arr[i]>smx) smx = arr[i];
        }

        int tmx = -1;
        for (int i = 0; i < n; i++) {
            if(arr[i] != smx && arr[i] != mx){
                if(arr[i]>tmx) tmx = arr[i];
            }
        }
//        System.out.println(mx);
        System.out.println(tmx);
    }
}
