# https://leetcode.com/problems/merge-in-between-linked-lists/

class Solution:
    def mergeInBetween(self, list1: Optional[ListNode], a: int, b: int, list2: Optional[ListNode]) -> Optional[ListNode]:
        node = list1
        for _ in range(a - 1):
            node = node.next
        node_before_a = node
        for _ in range(b - a + 2):
            node = node.next
        node_after_b = node
        node_before_a.next = list2
        tail = list2
        while tail.next:
            tail = tail.next
        tail.next = node_after_b
        return list1
