# https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

class Solution:
    def sortedArrayToBST(self, nums):
        def build(lo, hi):
            if lo > hi:
                return None
            mid = (lo + hi) // 2
            root = TreeNode(nums[mid])
            root.left = build(lo, mid - 1)
            root.right = build(mid + 1, hi)
            return root

        return build(0, len(nums) - 1)


class Solution2:
    def sortedArrayToBST(self, nums):
        mid = len(nums) // 2
        root = TreeNode(nums[mid])
        # stack entries: (parent, lo, hi, side)  side: 0=left, 1=right
        stack = [(root, 0, mid - 1, 0), (root, mid + 1, len(nums) - 1, 1)]
        while stack:
            parent, lo, hi, side = stack.pop()
            if lo > hi:
                continue
            m = (lo + hi) // 2
            node = TreeNode(nums[m])
            if side == 0:
                parent.left = node
            else:
                parent.right = node
            stack.append((node, lo, m - 1, 0))
            stack.append((node, m + 1, hi, 1))
        return root
