# https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

class Solution:
    def swapNodes(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        front = head
        for _ in range(k - 1):
            front = front.next
        back, cur = head, front
        while cur.next:
            cur = cur.next
            back = back.next
        front.val, back.val = back.val, front.val
        return head
