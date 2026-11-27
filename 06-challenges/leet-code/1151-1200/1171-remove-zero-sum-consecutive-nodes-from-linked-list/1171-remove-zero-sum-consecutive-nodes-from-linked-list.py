# https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/

class Solution:
    def removeZeroSumSublists(self, head) -> object:
        dummy = type('Node', (), {'val': 0, 'next': head})()
        prefix_map = {}
        prefix = 0
        node = dummy
        while node:
            prefix += node.val
            prefix_map[prefix] = node
            node = node.next
        prefix = 0
        node = dummy
        while node:
            prefix += node.val
            node.next = prefix_map[prefix].next
            node = node.next
        return dummy.next
