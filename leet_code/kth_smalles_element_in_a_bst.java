/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void populate_list(TreeNode curr, ArrayList<Integer> sorted_list, int k) {
        if (curr != null && sorted_list.size() < k) {
            if (curr.left == null && curr.right == null) {
                sorted_list.add(curr.val);
            } else {
                populate_list(curr.left, sorted_list, k);
                sorted_list.add(curr.val);
                populate_list(curr.right, sorted_list, k);
            }
        }
    }
    
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> sorted_list = new ArrayList<Integer>();
        populate_list(root, sorted_list, k);
        return sorted_list.get(k - 1);
    }
}