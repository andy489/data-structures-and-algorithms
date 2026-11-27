# https://leetcode.com/problems/maximum-binary-tree/

class Solution:
    def constructMaximumBinaryTree(self, nums: list) -> 'TreeNode':
        if not nums:
            return None
        max_idx = nums.index(max(nums))
        node = TreeNode(nums[max_idx])
        node.left = self.constructMaximumBinaryTree(nums[:max_idx])
        node.right = self.constructMaximumBinaryTree(nums[max_idx + 1:])
        return node
