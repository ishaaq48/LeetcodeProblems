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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode temp = head;
        ListNode temp2 = head.next;
        ListNode dummy  = head.next;
        
        while(temp.next != null && temp2.next !=null)
        {
            //updation odd
            temp.next = temp.next.next;
            temp = temp.next;
            //updation even
            temp2.next = temp2.next.next;
            temp2 = temp2.next;
        }
        
        temp.next = dummy;
        return head;
    }
}
