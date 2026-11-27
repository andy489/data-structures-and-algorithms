# https://leetcode.com/problems/split-linked-list-in-parts/

class Solution:
    def splitListToParts(self, head: Optional[ListNode], k: int) -> List[Optional[ListNode]]:
        n, curr = 0, head
        while curr:
            n += 1
            curr = curr.next
        base, extra = divmod(n, k)
        result = [None] * k
        curr = head
        for i in range(k):
            if not curr:
                break
            result[i] = curr
            size = base + (1 if i < extra else 0)
            for _ in range(size - 1):
                curr = curr.next
            curr.next, curr = None, curr.next
        return result
