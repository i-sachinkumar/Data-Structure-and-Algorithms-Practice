package daily_test.Dec16;

import daily_test.Dec16.FindCycleInList.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(10);

        node = reverseList(node);

        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }

    }


    // reverse by recursion
    public static ListNode reverseList(FindCycleInList.ListNode head) {
        return reverseList(null, head);
    }
    public static ListNode reverseList(ListNode prev, ListNode curr){
        if(curr == null){
            return prev;
        }
        ListNode temp = curr.next;
        curr.next = prev;

        return reverseList(curr,temp);
    }
}
