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
    
    public int maximum(TreeNode node, int n) {
        if (node.left == null && node.right == null) {
            return n;
        } else {
            int left_node = n;
            int right_node = n;
            if (node.left != null) {
                left_node = maximum(node.left, n + 1);
            }
            if (node.right != null) {
                right_node = maximum(node.right, n + 1);
            }
            return Math.max(left_node, right_node);
        }
    }
    
    public void fill(TreeNode node, List<List<Integer>> levels, int n) {
        levels.get(n).add(node.val);
        if (node.left != null) {
            fill(node.left, levels, n + 1);
        }
        if (node.right != null) {
            fill(node.right, levels, n + 1);
        }
    }
    
    
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        
        int maximum = maximum(root, 0);
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        for (int i = 0; i <= maximum; i++) {
            levels.add(new ArrayList<Integer>());
        }
        
        fill(root, levels, 0);
        return levels;
    }
}