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
    public boolean isPalindrome(ListNode head) {
        
        // find mid-point of list
        ListNode mid = head;
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        
        int count = 0;
        while (count < length / 2) {
            count++;
            mid = mid.next;
        }
        if (length % 2 != 0) {
            mid = mid.next;
        }
        
        // reverse list and check for equality of two halves
        mid = reverseList(mid);
        while (mid != null) {
            if (mid.val != head.val) {
                return false;
            }
            mid = mid.next;
            head = head.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head) {

           ListNode curr = head;
           ListNode prev = null;

           while (curr != null) {
               ListNode next = curr.next;
               curr.next = prev;
               prev = curr;
               curr = next;
           }
           return prev;
       }
}