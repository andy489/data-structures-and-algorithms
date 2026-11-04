# https://leetcode.com/problems/swap-nodes-in-pairs/

# Solution: Iterative (Dummy Head) — O(n) time, O(1) space
class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy

        while prev.next and prev.next.next:
            first = prev.next
            second = prev.next.next

            first.next = second.next
            second.next = first
            prev.next = second

            prev = first

        return dummy.next


# Solution2: Recursive — O(n) time, O(n) space
class Solution2:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        second = head.next
        head.next = self.swapPairs(second.next)
        second.next = head

        return second
