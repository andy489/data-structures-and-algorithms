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
        self.successor = None

        def reverse_n(node, n):
            if n == 1:
                self.successor = node.next
                return node
            new_head = reverse_n(node.next, n - 1)
            node.next.next = node
            node.next = self.successor
            return new_head

        def helper(node, lo, hi):
            if lo == 1:
                return reverse_n(node, hi)
            node.next = helper(node.next, lo - 1, hi - 1)
            return node

        return helper(head, left, right)
