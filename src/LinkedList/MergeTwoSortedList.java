package LinkedList;

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode curNode = root;
        while(list1 != null  || list2 != null) {
            if (list1 == null) {
                curNode.next = list2;
                break;
            }
            if (list2 == null) {
                curNode.next = list1;
                break;
            }
            int num1 = list1.val;
            int num2 = list2.val;
            if (num1 >= num2) {
                curNode.next = new ListNode(num2);
                list2 = list2.next;
            } else {
                curNode.next = new ListNode(num1);
                list1 = list1.next;
            }
            curNode = curNode.next;
        }
        return root.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
