# https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

class Solution:
    def getDecimalValue(self, head) -> int:
        res = 0
        while head:
            res = (res << 1) | head.val
            head = head.next
        return res
