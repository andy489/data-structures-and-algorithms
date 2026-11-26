# https://leetcode.com/problems/linked-list-cycle/

class Solution:
    def hasCycle(self, head) -> bool:
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow is fast:
                return True
        return False


class Solution2:
    def hasCycle(self, head) -> bool:
        visited = set()
        cur = head
        while cur:
            if id(cur) in visited:
                return True
            visited.add(id(cur))
            cur = cur.next
        return False


class Solution3:
    def hasCycle(self, head) -> bool:
        def detect(node, visited):
            if not node:
                return False
            if id(node) in visited:
                return True
            visited.add(id(node))
            return detect(node.next, visited)
        return detect(head, set())
