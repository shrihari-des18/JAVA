package Sorting_Advance;

public class QuickSort {
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
    public static void quick_sort(int[] arr, int lo, int hi){
        if(lo >= hi) return;
        int idx = partitionRandomisedPivot(arr,lo,hi);
        quick_sort(arr,lo,idx-1);
        quick_sort(arr,idx+1,hi);
    }
    public static int partitionRandomisedPivot(int[] arr, int lo, int hi){
//        To improve the worst case we randomize the pivot to mid
        int mid = (lo+hi)/2;
        int piv = arr[mid], pIdx = mid;
        int scount = 0;
        for (int i = lo; i <= hi; i++) {
            if(i==mid) continue;
            if(arr[i] <= piv) scount++;
        }
        int cIdx = lo + scount;
        swap(arr,pIdx,cIdx);

        int i = lo, j = hi;
        while(i < cIdx && j > cIdx){
            if(arr[i] <= piv) i++;
            else if(arr[j] > piv) j--;
            else if(arr[i] > piv && arr[j] <= piv) swap(arr, i, j);
        }
        return cIdx;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,5,1,6,3,0,8,4};
        int n = arr.length;
        quick_sort(arr,0,n-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
