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
    
    public void helper(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                helper(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                helper(node.right, list);
            }
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);
        System.out.println(list);
        int prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > prev) {
                prev = list.get(i);
            } else {
                return false;
            }
        }
        return true;
    }
}