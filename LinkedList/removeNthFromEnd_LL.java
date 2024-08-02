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
        ListNode temp = head;
        int cnt = 1;
        if(head.next == null ) 
        {
            head = null;
            return head;
        }
            
        while(temp != null)
        {
            cnt++;
            temp = temp.next;
        }
        temp = head;
        int pos = cnt - n;
        if(cnt == n+1){
            head = temp.next;
            return head;
        }
        for(int i = 0; i < pos-2; i++)
        {
            temp = temp.next;
        }
        
        temp.next = temp.next.next;
        return head;
    }
}
