package daily_test.Dec16;

// Qs Link = {https://leetcode.com/problems/reorder-list/}

import daily_test.Dec16.FindCycleInList.ListNode;

public class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(11);

        reorderList(node);

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }

    }

    public static void reorderList(ListNode head) {

        ListNode mid = findMid(head);

        ListNode tail_to_mid = reverse(null, mid);

        while(head != null && tail_to_mid != null){
            ListNode temp1 = head.next;
            head.next = tail_to_mid;
            head = head.next;

            ListNode temp2 = tail_to_mid.next;
            head.next = temp1;
            head = head.next;

            tail_to_mid = temp2;
        }
    }

    public static ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public static ListNode reverse(ListNode prev, ListNode head){
        if(head == null) return prev;

        ListNode temp = head.next;

        head.next = prev;

        return reverse(head ,temp);
    }
}
