# https://leetcode.com/problems/merge-k-sorted-lists/

import heapq

# Solution: Min-Heap (Priority Queue) — O(N log k) time, O(k) space
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for i, node in enumerate(lists):
            if node:
                heapq.heappush(heap, (node.val, i, node))

        dummy = ListNode(0)
        curr = dummy

        while heap:
            val, i, node = heapq.heappop(heap)
            curr.next = node
            curr = curr.next
            if node.next:
                heapq.heappush(heap, (node.next.val, i, node.next))

        return dummy.next


# Solution2: Divide and Conquer — O(N log k) time, O(log k) space
class Solution2:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        return self._mergeRange(lists, 0, len(lists) - 1)

    def _mergeRange(self, lists, lo, hi):
        if lo == hi:
            return lists[lo]
        mid = (lo + hi) // 2
        left = self._mergeRange(lists, lo, mid)
        right = self._mergeRange(lists, mid + 1, hi)
        return self._mergeTwoLists(left, right)

    def _mergeTwoLists(self, l1, l2):
        dummy = ListNode(0)
        curr = dummy
        while l1 and l2:
            if l1.val <= l2.val:
                curr.next = l1
                l1 = l1.next
            else:
                curr.next = l2
                l2 = l2.next
            curr = curr.next
        curr.next = l1 if l1 else l2
        return dummy.next
