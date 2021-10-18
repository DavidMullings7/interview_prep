# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def helper(self, curr: Optional[TreeNode], target: int, parent: int, depth: int) -> tuple:
        if curr == None:
            return None
        elif curr.val == target:
            return depth, parent
        left_val: tuple = self.helper(curr.left, target, curr.val, depth + 1)
        if left_val != None:
            return left_val
        return self.helper(curr.right, target, curr.val, depth + 1)
    
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        x_depth_parent = self.helper(root, x, -1, 0)
        y_depth_parent = self.helper(root, y, -1, 0)
        return x_depth_parent[0] == y_depth_parent[0] and x_depth_parent[1] != y_depth_parent[1]