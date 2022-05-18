package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {100, -1, -72, 1, 3, 0, 8, 6};
        merge_sort(a);

        for(int i : a){
            System.out.print(i + " ");
        }
    }


    public static void merge_sort(int[] a){
        merge_sort(a, 0 , a.length-1);
    }


    private static void merge_sort(int[] a, int l, int h) {
        if(l>=h) return;
        int mid = (l+h)/2;

        merge_sort(a,l,mid);
        merge_sort(a,mid+1,h);

        merge(a, l , mid, h);
    }

    private static void merge(int[] a, int l, int mid, int h) {
        //sorted array till mid
        int[] left = new int[mid-l+1];

        //sorted array after mid
        int[] right = new int[h-mid];

        //adding element to left sorted sub-array
        if (mid - l + 1 >= 0) System.arraycopy(a, l, left, 0, mid - l + 1);

        //adding element to right sorted sub-array
        for(int i = 0 ; i < h - mid ; i++) {
            right[i] = a[mid + 1 + i];
        }

        int i = 0;
        int j = 0;

        // merging
        //adding smaller from both sub-array entry to the a[]
        while(i < left.length && j < right.length){
            if(left[i] < right[j]){
                a[l] = left[i];
                i++;
            }
            else{
                a[l] = right[j];
                j++;
            }
            l++;
        }

        // if left sub-array is not iterated completely
        while(i < left.length){
            a[l] = left[i];
            i++;
            l++;
        }

        // if right sub-array is not iterated completely
        while(j < right.length){
            a[l] = right[j];
            j++;
            l++;
        }

    }


    public static void merge1(int[] a, int l, int m, int h){

        int[] left = new int[m-l+1];
        int[] right = new int[h-m];

        for(int i = 0 ; i < m-l+1; i++){
            left[i] = a[l+i];
        }
        for(int i = 0 ; i < h-m ; i++){
            right[i] = a[m+i+1];
        }

        int i = 0;
        int j = 0;

        while (i < left.length && j < right.length){
            if(left[i] < right[j]){
                a[l] = left[i];
                i++;
            }
            else{
                a[l] = right[j];
                j++;
            }
            l++;
        }

        // if left sub-array is not iterated completely
        while(i < left.length){
            a[l] = left[i];
            i++;
            l++;
        }

        // if right sub-array is not iterated completely
        while(j < right.length){
            a[l] = right[j];
            j++;
            l++;
        }
    }
}
