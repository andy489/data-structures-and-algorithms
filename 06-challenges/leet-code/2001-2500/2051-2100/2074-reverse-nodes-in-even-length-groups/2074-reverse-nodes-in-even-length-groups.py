# https://leetcode.com/problems/reverse-nodes-in-even-length-groups/

class Solution:
    def reverseEvenLengthGroups(self, head) -> 'ListNode':
        prev = head
        group_size = 2
        while prev.next:
            node = prev
            length = 0
            for _ in range(group_size):
                if not node.next:
                    break
                node = node.next
                length += 1
            if length % 2 == 1:
                prev = node
            else:
                group_prev = prev
                curr = group_prev.next
                tail = curr
                rev = None
                for _ in range(length):
                    nxt = curr.next
                    curr.next = rev
                    rev = curr
                    curr = nxt
                group_prev.next = rev
                tail.next = curr
                prev = tail
            group_size += 1
        return head
