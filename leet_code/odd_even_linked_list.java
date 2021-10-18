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
        
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        
        ListNode even_head = head;
        ListNode odd_head = head.next;
        ListNode prev_even = even_head;
        ListNode prev_odd = odd_head;
        ListNode current = odd_head.next;
        prev_even.next = null;
        prev_odd.next = null;
        boolean is_even = true;
        while (current != null) {
            ListNode temp = current.next;
            if (is_even) {
                prev_even.next = current;
                prev_even = current;
                prev_even.next = null;
            } else {
                prev_odd.next = current;
                prev_odd = current;
                prev_odd.next = null;
            }
            
            is_even = is_even ^ true;
            current = temp;
        }
        
        prev_even.next = odd_head;
        return even_head;
    }
}