# https://leetcode.com/problems/odd-even-linked-list/

class Solution:
    def oddEvenList(self, head) -> object:
        if not head:
            return None
        odd, even, even_head = head, head.next, head.next
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = even_head
        return head
