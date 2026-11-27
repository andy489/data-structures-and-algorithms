# https://leetcode.com/problems/reverse-nodes-in-k-group/

# Solution: Iterative (Dummy Head) — O(n) time, O(1) space
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy

        while True:
            kth = self._get_kth(prev, k)
            if not kth:
                break

            next_group = kth.next
            curr = prev.next

            while curr != next_group:
                nxt = curr.next
                curr.next = kth.next
                kth.next = curr
                curr = nxt

            tail = prev.next
            prev.next = kth
            prev = tail

        return dummy.next

    def _get_kth(self, curr: Optional[ListNode], k: int) -> Optional[ListNode]:
        while curr and k > 0:
            curr = curr.next
            k -= 1
        return curr


# Solution2: Recursive — O(n) time, O(n/k) space
class Solution2:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        kth = head
        count = 0
        while kth and count < k:
            kth = kth.next
            count += 1
        if count < k:
            return head

        prev = None
        curr = head
        while curr != kth:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        head.next = self.reverseKGroup(kth, k)
        return prev
