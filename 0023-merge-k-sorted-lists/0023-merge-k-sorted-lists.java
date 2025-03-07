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
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<Integer> pq = new PriorityQueue<>();
       
       // adding value in min heap
       for (int i = 0; i < lists.length; i++) {
        ListNode node = lists[i];
            while (node != null) {
                pq.add(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

       
         //extracting values from min heap and creating listnode
        while(!pq.isEmpty()){
            current.next = new ListNode(pq.poll());
            current = current.next;
        }

        return dummy.next;
    }
}