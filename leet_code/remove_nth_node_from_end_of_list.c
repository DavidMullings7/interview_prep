/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* removeNthFromEnd(struct ListNode* head, int n){

    // use a two-pointer approach. Create delay in second pointer
    struct ListNode* fast = head;
    struct ListNode* slow = head;
    for (int i = 1; i <= n; i++) {
        fast = fast->next;
    }
    
    // if fast pointer reaches end, remove first element of linked list
    if (fast == NULL) {
        struct ListNode* temp = slow->next;
        free(slow);
        return temp;
    }
    
    // continue incrementing pointers until fast pointer reaches end node
    while (fast->next != NULL) {
        fast = fast->next;
        slow = slow->next;
    }
    
    // update linked list and return head
    struct ListNode* temp = slow->next->next;
    free(slow->next);
    slow->next = temp;
    return head;
}