# https://leetcode.com/problems/reverse-linked-list-ii/

class Solution:
    def reverseBetween(self, head, left: int, right: int):
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        for _ in range(left - 1):
            prev = prev.next
        curr = prev.next
        for _ in range(right - left):
            nxt = curr.next
            curr.next = nxt.next
            nxt.next = prev.next
            prev.next = nxt
        return dummy.next


# Solution 2: Recursion — O(n) time, O(n) space
class Solution2:
    def reverseBetween(self, head, left: int, right: int):
        self.tail = None

        def helper(node, lo, hi):
            if hi == 1:
                self.tail = node.next
                return node
            if lo == 1:
                successor = node.next
                new_head = helper(successor, 1, hi - 1)
                successor.next = node
                node.next = self.tail
                self.tail = node
                return new_head
            node.next = helper(node.next, lo - 1, hi - 1)
            return node

        return helper(head, left, right)
