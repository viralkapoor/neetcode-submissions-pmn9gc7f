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
        ListNode ptr = head;
        int count=1;

        while(count<k && ptr!=null) {
            ptr=ptr.next;
            count++;
        }
        if(ptr==null)
            return head;
        ListNode next = ptr.next;
        ptr.next=null;
        ListNode newHead = reverse(head);
        head.next = reverseKGroup(next, k);
        return newHead;
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
