package daily_test.Dec16;

import daily_test.Dec16.FindCycleInList.ListNode;

public class MergeMultipleSortedList {
    public static void main(String[] args) {

    }


    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;


        return mergeUtil(lists, 0, n-1);
    }


    public static ListNode mergeUtil(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        return mergeTwoLists(mergeUtil(lists, start, mid), mergeUtil(lists, mid + 1, end));
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // if at least one list is empty
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        // if both are not null
        int val; // first val to initialize our linkedList
        if(list1.val < list2.val){
            val = list1.val;
            list1 = list1.next;
        }
        else{
            val = list2.val;
            list2 = list2.next;
        }

        ListNode root = new ListNode(val);
        ListNode ans = root;

        // when both list have elements
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                root.next = new ListNode(list1.val);
                root = root.next;
                list1 = list1.next;
            }
            else{
                root.next = new ListNode(list2.val);
                root = root.next;
                list2 = list2.next;
            }
        }

        // if list2 is now null and element in list1 is remaining
        while(list1 != null){
            root.next = new ListNode(list1.val);
            root = root.next;
            list1 = list1.next;
        }

        // if list1 is now null and element in list2 is remaining
        while(list2 != null){
            root.next = new ListNode(list2.val);
            root = root.next;
            list2 = list2.next;
        }

        return ans;
    }

}
