/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* helper(struct ListNode* node, int val) {
    if (node == NULL) {
        return NULL;
    } else if (node->val == val) {
        struct ListNode* temp = node;
        return helper(node->next, val);
        free(temp);
    } 
    
    node->next = helper(node->next, val);
    return node;
}

struct ListNode* removeElements(struct ListNode* head, int val){
    return helper(head, val);
    
/* alternative iterative solution */
//     while (head != NULL && head->val == val) {
//         struct ListNode* temp = head;
//         head = head->next;
//         free(temp);
//     }
    
//     struct ListNode* curr = head;
//     while (curr != NULL && curr->next != NULL) {
//         if (curr->next->val == val) {
//             struct ListNode* temp = curr->next;
//             curr->next = curr->next->next;
//             free(temp);
//         } else {
//             curr = curr->next;
//         }
//     }
//     return head;
}