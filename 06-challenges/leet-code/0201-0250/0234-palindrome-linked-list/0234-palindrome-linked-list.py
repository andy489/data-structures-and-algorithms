# https://leetcode.com/problems/palindrome-linked-list/

class Solution:
    def isPalindrome(self, head: 'ListNode | None') -> bool:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        second = self._reverse(slow)
        left = head
        while second:
            if left.val != second.val:
                return False
            left = left.next
            second = second.next
        return True

    def _reverse(self, head: 'ListNode | None') -> 'ListNode | None':
        prev = None
        while head:
            head.next, prev, head = prev, head, head.next
        return prev
