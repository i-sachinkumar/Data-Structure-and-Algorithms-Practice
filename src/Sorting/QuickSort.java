package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {100, -1, -72, 1, 3, 0, 8, 6};
        quick_sort(a,0,7);

        for(int i : a){
            System.out.print(i + " ");
        }
    }

    private static void quick_sort(int[] a, int l , int h) {
        if(l >= h) return;
        int p = partition(a,l,h);
        quick_sort(a,l,p-1);
        quick_sort(a,p+1,h);
    }

    static int partition(int[] a, int l , int h){
        int i = l;
        int j = h;
        int pivot = a[l];

        while(i < j){
            while (a[i] <= pivot && i < h ) i++;
            while (a[j] >= pivot && j > l) j--;
            if(i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[l];
        a[l] = a[j];
        a[j] = temp;

        return j;
    }
}
