/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode slow = head;
        while (slow != null) {
            boolean hasDuplicate = false;
            while (slow.next != null && slow.val == slow.next.val) {
                hasDuplicate = true;
                slow = slow.next;
            }
            if(hasDuplicate) prev.next = slow.next;
            else prev = prev.next;

            slow = slow.next;    
        }
        return dummy.next;
    }
}