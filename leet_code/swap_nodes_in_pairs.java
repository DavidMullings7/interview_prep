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
    public ListNode swapPairs(ListNode head) {
        
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }
        
        ListNode temp = head;
        ListNode next = head.next.next;
        head = head.next;
        head.next = temp;
        temp.next = swapPairs(next);
        return head;
    }
}