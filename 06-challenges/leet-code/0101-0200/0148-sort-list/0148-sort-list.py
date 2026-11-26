# https://leetcode.com/problems/sort-list/

# Solution 1: Top-down merge sort — O(n log n) time, O(log n) space
class Solution:
    def sortList(self, head):
        if not head or not head.next:
            return head
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        mid = slow.next
        slow.next = None
        return self._merge(self.sortList(head), self.sortList(mid))

    def _merge(self, l1, l2):
        dummy = ListNode(0)
        curr = dummy
        while l1 and l2:
            if l1.val <= l2.val:
                curr.next = l1; l1 = l1.next
            else:
                curr.next = l2; l2 = l2.next
            curr = curr.next
        curr.next = l1 or l2
        return dummy.next


# Solution 2: Bottom-up merge sort — O(n log n) time, O(1) space
class Solution2:
    def sortList(self, head):
        n, x = 0, head
        while x:
            n += 1; x = x.next
        dummy = ListNode(0)
        dummy.next = head
        size = 1
        while size < n:
            curr = dummy.next
            tail = dummy
            while curr:
                left = curr
                right = self._split(left, size)
                curr = self._split(right, size)
                merged_head, merged_tail = self._merge(left, right)
                tail.next = merged_head
                tail = merged_tail
            size <<= 1
        return dummy.next

    def _split(self, head, n):
        for _ in range(n - 1):
            if not head:
                break
            head = head.next
        if not head:
            return None
        rest = head.next
        head.next = None
        return rest

    def _merge(self, l1, l2):
        dummy = ListNode(0)
        curr = dummy
        while l1 and l2:
            if l1.val <= l2.val:
                curr.next = l1; l1 = l1.next
            else:
                curr.next = l2; l2 = l2.next
            curr = curr.next
        curr.next = l1 or l2
        while curr.next:
            curr = curr.next
        return dummy.next, curr
