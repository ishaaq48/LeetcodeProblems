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
    public ListNode partition(ListNode head, int x) {

        if(head == null || head.next == null) return head;
        ListNode smaller = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode smaller_head = smaller;
        ListNode greater_head = greater;
        ListNode temp = head;

        while(temp != null){
            if(temp.val < x){
                smaller.next = temp;
                smaller = smaller.next;
            }
            else{
                greater.next = temp;
                greater = greater.next;
            }
            temp = temp.next;
        }

        greater.next = null;
        smaller.next = greater_head.next;

        return smaller_head.next;
    }
}