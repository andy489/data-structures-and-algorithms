# https://leetcode.com/problems/remove-nth-node-from-end-of-list/

from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Solution 1: Two Pointers (One Pass) — O(n) time, O(1) space
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        slow, fast = dummy, dummy

        for _ in range(n + 1):    # gap of n+1 so slow lands before the target
            fast = fast.next

        while fast:               # advance together until fast falls off
            slow = slow.next
            fast = fast.next

        slow.next = slow.next.next  # unlink the nth-from-end node
        return dummy.next

# Solution 2: Recursive — O(n) time, O(n) space
class Solution2:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        self._dfs(dummy, n)
        return dummy.next

    # returns depth from end; removes the node when depth == n
    def _dfs(self, node: ListNode, n: int) -> int:
        if not node.next:
            return 0                              # base: tail is depth 0 from end

        depth = self._dfs(node.next, n) + 1      # depth of node.next from end, +1 for this edge

        if depth == n:
            node.next = node.next.next            # skip the target node

        return depth
