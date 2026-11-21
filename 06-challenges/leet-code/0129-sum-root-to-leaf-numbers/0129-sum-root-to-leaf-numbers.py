# https://leetcode.com/problems/sum-root-to-leaf-numbers/

# Solution 1: Recursive DFS — O(n) time, O(h) space
class Solution:
    def sumNumbers(self, root) -> int:
        def dfs(node, curr: int) -> int:
            if not node:
                return 0
            curr = curr * 10 + node.val
            if not node.left and not node.right:
                return curr
            return dfs(node.left, curr) + dfs(node.right, curr)
        return dfs(root, 0)


# Solution 2: Iterative DFS — O(n) time, O(h) space
class Solution2:
    def sumNumbers(self, root) -> int:
        ans = 0
        stack = [(root, 0)]
        while stack:
            node, curr = stack.pop()
            curr = curr * 10 + node.val
            if not node.left and not node.right:
                ans += curr
            else:
                if node.right:
                    stack.append((node.right, curr))
                if node.left:
                    stack.append((node.left, curr))
        return ans
