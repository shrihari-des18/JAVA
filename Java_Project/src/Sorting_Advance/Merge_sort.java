package Sorting_Advance;

public class Merge_sort {
    public static void merge(int[] a, int[] b, int[] c){
        int i=0, j=0, k=0;
        while(i<a.length && j<b.length){
            if(a[i] <= b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }
        while(j < b.length) c[k++] = b[j++];
        while(i < a.length) c[k++] = a[i++];
    }
    public static void merge_sort(int[] arr){
        int n = arr.length;
        if(n==1) return;
        int[] a = new int[n/2]; int[] b = new int[n-n/2];

        for (int i = 0; i < n / 2; i++) a[i] = arr[i];
        for (int i = 0; i < n - n / 2; i++) b[i] = arr[i+n/2];

        merge_sort(a);
        merge_sort(b);
        merge(a,b,arr);

        //to improve the space complexity we delete arrays;
        a = null; b = null;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,1,6,3,0,8,4};
        merge_sort(arr);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
