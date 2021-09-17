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
    
    public int helper(TreeNode root, int maximum) {
        int left_maximum = maximum;
        int right_maximum = maximum;
        if (root.left != null) {
            left_maximum = helper(root.left, maximum + 1);
        }
        
        if (root.right != null) {
            right_maximum = helper(root.right, maximum + 1);
        }
        
        return Math.max(left_maximum, right_maximum);
    }
    
    public void help_traverse(TreeNode node, List<List<Integer>> zig, int index) {
        zig.get(index).add(node.val);
        if (node.left != null) {
            help_traverse(node.left, zig, index + 1);
        }
        if (node.right != null) {
            help_traverse(node.right, zig, index + 1);
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        
        int maximum = helper(root, 0);
        List<List<Integer>> zig_zag = new ArrayList<List<Integer>>();
        for (int i = 0; i <= maximum; i++) {
            zig_zag.add(new ArrayList<Integer>());
        }
        help_traverse(root, zig_zag, 0);
        for (int i = 0; i <= maximum; i++) {
            if (i % 2 == 1) {
                Collections.reverse(zig_zag.get(i));
            }
        }
        return zig_zag;
    }
}