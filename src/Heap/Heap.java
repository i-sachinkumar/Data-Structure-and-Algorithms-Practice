package Heap;

import java.util.ArrayList;
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




    public static void main(String[] args) {
        Heap maxHeap = new Heap();
        maxHeap.insert(50);
        maxHeap.insert(25);
        maxHeap.insert(35);
        maxHeap.insert(30);
        maxHeap.insert(20);
        maxHeap.insert(40);

        maxHeap.print();

        maxHeap.delete(50);

        maxHeap.print();



    }
}
