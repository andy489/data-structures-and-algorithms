# https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
class Solution:
    def pairSum(self, head) -> int:
        # Find middle
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        # Reverse second half
        prev, curr = None, slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next
        # Compute max twin sum
        max_sum = 0
        left, right = head, prev
        while right:
            max_sum = max(max_sum, left.val + right.val)
            left = left.next
            right = right.next
        return max_sum
