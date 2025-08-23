package LinkedList;

import java.util.List;

public class RemoveNthNodeFromEnd {
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
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            if (head.next == null && n == 1) {
                return null;
            }
            int sizeCount = 1;
            ListNode cur = head;
            while(cur.next != null) {
                cur = cur.next;
                sizeCount ++;
            }
            int target = sizeCount - n;
            ListNode root = new ListNode();
            root.next = head;
            int count = 0;
            ListNode targetCur = root;
            while (count < target) {
                targetCur = targetCur.next;
                count ++;
            }
            targetCur.next = targetCur.next.next;
            return root.next;
        }

        private ListNode swap(ListNode cur, ListNode next) {
            if (next.next == null) {
                next.next = cur;
                return next;
            } else {
                ListNode temp = next.next;
                next.next = cur;
                return this.swap(next, temp);
            }
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
