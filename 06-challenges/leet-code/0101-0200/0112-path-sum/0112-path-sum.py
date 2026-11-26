# https://leetcode.com/problems/path-sum/

class Solution:
    def hasPathSum(self, root, targetSum: int) -> bool:
        if not root:
            return False
        targetSum -= root.val
        if not root.left and not root.right:
            return targetSum == 0
        return self.hasPathSum(root.left, targetSum) or self.hasPathSum(root.right, targetSum)


class Solution2:
    def hasPathSum(self, root, targetSum: int) -> bool:
        if not root:
            return False
        stack = [(root, targetSum - root.val)]
        while stack:
            node, remaining = stack.pop()
            if not node.left and not node.right and remaining == 0:
                return True
            if node.right:
                stack.append((node.right, remaining - node.right.val))
            if node.left:
                stack.append((node.left, remaining - node.left.val))
        return False


class Solution3:
    def hasPathSum(self, root, targetSum: int) -> bool:
        if not root:
            return False
        from collections import deque
        queue = deque([(root, targetSum - root.val)])
        while queue:
            node, remaining = queue.popleft()
            if not node.left and not node.right and remaining == 0:
                return True
            if node.left:
                queue.append((node.left, remaining - node.left.val))
            if node.right:
                queue.append((node.right, remaining - node.right.val))
        return False
