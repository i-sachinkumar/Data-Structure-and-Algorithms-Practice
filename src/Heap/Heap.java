package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap {
    List<Integer> list;

    Heap(){
        list = new ArrayList<>();
    }

/*************** Insert **********************************************************************************************************************/
    public void insert(int val){
        list.add(val);
        int i = list.size()-1;
        while (i > 0){
            if(list.get(i) > list.get(i/2)){
                int temp = list.get(i);
                list.set(i, list.get(i/2));
                list.set(i/2 , temp);
                i = i/2;
            }
            else return;
        }
    }
//***************** End of Insert *********************************************************************************************************





/****************** Print ***********************************************************************************************************/
    public void print(){
        System.out.println(list);
    }
//**************** End of Print ******************************************************************************************************




/***************** Delete *****************************************************************************************************************/
    public void delete(int val){
        int i = 0;
        while (i < list.size()){
            if(list.get(i) == val) break;
            i++;
        }
        if(i == list.size()){
            throw new NoSuchElementException(val + " is not found in heap");
        }
        int lastVal = list.get(list.size()-1);
        list.remove(list.size()-1);
        list.set(i,lastVal);
        while (i < (list.size()-1)/2){
            int left = list.get((2*i)+1);
            int right = list.get((2*i)+2);

            if(left > right){
                int temp = list.get(i);
                list.set(i, left);
                list.set((2*i)+1,temp);
                i = (2*i)+1;
            }
            if(left < right){
                int temp = list.get(i);
                list.set(i, right);
                list.set((2*i)+2,temp);
                i = (2*i)+2;
            }
        }
    }
//**************** End of Delete *********************************************************************************************************************



/****************** Heapify and heapSort *****************************************************************************************************************/
    public void heapify(int[] a, int l, int r) {
        int n = r + 1;
        if (2 * l + 1 >= n) return;
        else if (2 * l + 2 == n) {
            if (a[l] < a[2 * l + 1]) {
                int temp = a[l];
                a[l] = a[2 * l + 1];
                a[2 * l + 1] = temp;
            }
        } else {
            int left = a[2 * l + 1];
            int right = a[2 * l + 2];
            if (left > right) {
                if (a[l] < left) {
                    a[2 * l + 1] = a[l];
                    a[l] = left;
                    heapify(a, 2 * l + 1, r);
                }
            } else {
                if (a[l] < right) {
                    a[2 * l + 2] = a[l];
                    a[l] = right;
                    heapify(a, 2 * l + 2, r);
                }
            }
        }
    }


    public void buildHeap(int[] a){
        for(int i = (a.length-1)/2; i>=0 ; i--){
            heapify(a, i,  a.length-1);
        }
    }

    public void heapSort(int[] a){

    }
//************** End of heapify & heap Sort ***********************************************************************************************



    public static void main(String[] args) {
        Heap maxHeap = new Heap();
        maxHeap.insert(50);
        maxHeap.insert(25);
        maxHeap.insert(35);
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(40);

        System.out.println("max heap: ");
        maxHeap.print();

        System.out.println("after deleting 50: ");
        maxHeap.delete(50);

        maxHeap.print();

        System.out.println("********** heapify ************");
        int[] a = {25,35,30,20,40,50};
        
        maxHeap.buildHeap(a);
        System.out.println(Arrays.toString(a));


    }
}
