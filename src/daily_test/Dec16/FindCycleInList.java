package daily_test.Dec16;

import java.util.HashSet;
import java.util.Set;

public class FindCycleInList {

    // node
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(10);
        node.next.next.next.next = node.next;

     /*  1 ----> 3 ----> 5 ----> 10 ->,
                  `-----<------<------'

               it has cycle as shown above
      */

        System.out.println(hasCycle(node));
        System.out.println(hasCycle2(node));

        // break the cycle
        node.next.next.next.next =null;

        System.out.println(hasCycle(node));
        System.out.println(hasCycle2(node));

    }


     public static boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();

        while (head != null) {
            if (!s.add(head)) {
                break;
            }
            head = head.next;
        }

         return head != null;
    }

    public static boolean hasCycle2(ListNode head) {
        if(head== null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
