# https://leetcode.com/problems/same-tree/

class Solution:
    def isSameTree(self, p, q) -> bool:
        if p is None and q is None:
            return True
        if p is None or q is None:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)


# Solution 2: Iterative BFS — O(n) time, O(n) space
from collections import deque

class Solution2:
    def isSameTree(self, p, q) -> bool:
        dq = deque([(p, q)])
        while dq:
            a, b = dq.popleft()
            if a is None and b is None:
                continue
            if a is None or b is None:
                return False
            if a.val != b.val:
                return False
            dq.append((a.left, b.left))
            dq.append((a.right, b.right))
        return True


# Solution 3: Iterative DFS — O(n) time, O(h) space
class Solution3:
    def isSameTree(self, p, q) -> bool:
        stack = [(p, q)]
        while stack:
            a, b = stack.pop()
            if a is None and b is None:
                continue
            if a is None or b is None:
                return False
            if a.val != b.val:
                return False
            stack.append((a.left, b.left))
            stack.append((a.right, b.right))
        return True
