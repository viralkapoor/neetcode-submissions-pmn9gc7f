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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return head;
        ListNode tail = null, ptr = head;
        int count=1;

        while(count<k && ptr.next!=null) {
            ptr=ptr.next;
            count++;
        }
        if(count<k)
            return head;
        tail = ptr;
        ListNode next = tail.next;
        tail.next=null;
        reverse(head);
        head.next = reverseKGroup(next, k);
        return tail;
    }

    public ListNode reverse(ListNode head) {
        if(head==null)
            return head;
        ListNode prev = null, curr = head, next = curr.next;

        while(curr!=null) {
            curr.next=prev;
            prev = curr;
            curr = next;
            if(curr!=null)
                next=curr.next;
        }
        return prev;
    }
}
