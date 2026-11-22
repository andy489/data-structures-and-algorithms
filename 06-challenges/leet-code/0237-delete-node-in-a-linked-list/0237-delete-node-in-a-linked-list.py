# https://leetcode.com/problems/delete-node-in-a-linked-list/

class Solution:
    def deleteNode(self, node: 'ListNode') -> None:
        node.val = node.next.val
        node.next = node.next.next
