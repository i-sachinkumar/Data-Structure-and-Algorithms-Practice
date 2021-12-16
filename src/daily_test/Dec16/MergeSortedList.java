package daily_test.Dec16;




public class MergeSortedList {

    // node
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(10);


        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(2);
        node2.next.next = new ListNode(6);
        node2.next.next.next = new ListNode(8);

        // merging
        ListNode merged = mergeTwoLists(node, node2);

        while (merged != null){
            System.out.print(merged.val + " ");
            merged = merged.next;
        }


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
