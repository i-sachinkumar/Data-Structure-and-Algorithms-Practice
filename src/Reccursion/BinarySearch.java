package Reccursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a =  {5,7,7,8,8,10};
        System.out.println(index(a,10,0,5));
    }

    public static int index(int[] arr, int x, int l , int r){
        if (r >= l) {
            int mid = l + (r - l)/2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return index(arr, x, l, mid-1);

            // Else the element can only be present
            // in right subarray
            return index(arr, x, mid+1, r);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
