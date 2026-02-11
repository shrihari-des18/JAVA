package Sorting_Advance;

public class QuickSelect {
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int partition(int[] arr, int lo, int hi){
        int piv = arr[lo], pIdx = lo;
        int scount = 0;
        for (int i = lo+1; i <= hi; i++) {
            if(arr[i] <= piv) scount++;
        }
        int cIdx = pIdx + scount;
        swap(arr,pIdx,cIdx);

        int i = lo, j = hi;
        while(i < cIdx && j > cIdx){
            if(arr[i] <= piv) i++;
            else if(arr[j] > piv) j--;
            else if(arr[i] > piv && arr[j] <= piv) swap(arr, i, j);
        }
        return cIdx;
    }
    public static int quick_select(int[] arr, int lo, int hi, int k){
        if(lo > hi) return -1;
        int idx = partition(arr,lo,hi);
        if(idx == k-1){
            return arr[idx];
        }
        else if(k-1 < idx) return quick_select(arr,lo,idx-1,k);
        else return quick_select(arr,idx+1,hi,k);
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        int n = arr.length;
        int k = 20;
        int ans = quick_select(arr,0,n-1,n-k+1);
        System.out.println(ans);
    }
}
