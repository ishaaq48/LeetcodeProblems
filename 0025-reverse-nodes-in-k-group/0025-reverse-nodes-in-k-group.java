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
        if(head == null || k == 1) return head;
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        temp = head;
  
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (cnt >= k) {
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = groupStart;


            for (int i = 1; i < k; i++) {
                groupEnd = groupEnd.next;
            }
            ListNode nextGroupStart = groupEnd.next;

            reverseList(groupStart, groupEnd);

            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;

            prevGroupEnd = groupStart;
            cnt -= k;
        }

        return dummy.next;
    }
    public void reverseList(ListNode h, ListNode t){
        ListNode prev = null;
        ListNode curr = h;
        while(prev != t){
            ListNode nexNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nexNode;
        }
    }
}