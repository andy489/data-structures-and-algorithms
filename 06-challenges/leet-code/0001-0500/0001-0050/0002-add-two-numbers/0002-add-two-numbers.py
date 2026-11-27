# https://leetcode.com/problems/add-two-numbers/

class Solution:
    def addTwoNumbers(self, l1, l2):
        dummy = ListNode(0)
        cur = dummy
        carry = 0

        while l1 or l2:
            val = carry
            if l1:
                val += l1.val
                l1 = l1.next
            if l2:
                val += l2.val
                l2 = l2.next
            carry, rem = divmod(val, 10)
            cur.next = ListNode(rem)
            cur = cur.next

        if carry:
            cur.next = ListNode(carry)

        return dummy.next
