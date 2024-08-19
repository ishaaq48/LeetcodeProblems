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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy;


        for (int i = 1; i < left; i++) {
            leftPrev = leftPrev.next;
        }
       
       ListNode prev = leftPrev.next;
       ListNode newHead = prev;
       ListNode curr = prev.next;
       for(int i = 0; i < right-left; i++)
       {
        ListNode newNode = curr.next;
        curr.next = prev;

        prev = curr;
        curr = newNode;
       }
       newHead.next = curr;
       leftPrev.next = prev; 
    return dummy.next;
    }
}