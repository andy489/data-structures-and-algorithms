# https://leetcode.com/problems/validate-binary-search-tree/

# Solution: Bounded Recursion — O(n) time, O(h) space
class Solution:
    def isValidBST(self, root) -> bool:
        def validate(node, lo, hi):
            if node is None:
                return True
            if node.val <= lo or node.val >= hi:
                return False
            return validate(node.left, lo, node.val) and validate(node.right, node.val, hi)

        return validate(root, float('-inf'), float('inf'))


# Solution 2: Iterative In-order Traversal — O(n) time, O(h) space
class Solution2:
    def isValidBST(self, root) -> bool:
        stack = []
        prev = float('-inf')
        curr = root
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
            curr = stack.pop()
            if curr.val <= prev:
                return False
            prev = curr.val
            curr = curr.right
        return True
