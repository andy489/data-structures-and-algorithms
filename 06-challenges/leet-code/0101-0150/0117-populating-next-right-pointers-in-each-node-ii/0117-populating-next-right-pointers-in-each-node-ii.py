# https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

from collections import deque

# Solution 1: BFS (level-order) — O(n) time, O(n) space
class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return None
        q = deque([root])
        while q:
            size = len(q)
            for i in range(size):
                node = q.popleft()
                if i < size - 1:
                    node.next = q[0]
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
        return root


# Solution 2: O(1)-space dummy-head level traversal — O(n) time, O(1) space
class Solution2:
    def connect(self, root: 'Node') -> 'Node':
        curr = root
        while curr:
            dummy = Node(0)
            tail = dummy
            while curr:
                if curr.left:
                    tail.next = curr.left
                    tail = tail.next
                if curr.right:
                    tail.next = curr.right
                    tail = tail.next
                curr = curr.next
            curr = dummy.next
        return root
