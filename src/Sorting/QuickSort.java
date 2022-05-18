package Sorting;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {24, 9, 29, 14, 19, 27, 24};

//        quick_sort(a,0,7);
//
//        for(int i : a){
//            System.out.print(i + " ");
//        }
        Arrays.toString(a);
        String s = "eklvejvn";
        System.out.println(String.valueOf(s));
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        q.add(2);
        q.add(5);
        q.add(0);

        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());


//        partition1(a, 0, a.length-1);
//        System.out.println(Arrays.toString(a));
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




    public static int partition1(int[] arr, int l, int h){
        int i = l;
        int j = h;
        int pivot = arr[l];

        while(i < j){
            while (arr[i] <= pivot && i < h) i++;
            while (arr[j] >= pivot && j > l) j--;
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;

        return j;
    }
}
