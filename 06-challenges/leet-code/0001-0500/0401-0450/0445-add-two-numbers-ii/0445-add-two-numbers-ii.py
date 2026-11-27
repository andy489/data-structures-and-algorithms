# https://leetcode.com/problems/add-two-numbers-ii/

class Solution:
    def addTwoNumbers(self, l1, l2):
        stack1, stack2 = [], []
        node = l1
        while node:
            stack1.append(node.val)
            node = node.next
        node = l2
        while node:
            stack2.append(node.val)
            node = node.next
        carry = 0
        head = None
        while stack1 or stack2 or carry:
            total = carry
            if stack1:
                total += stack1.pop()
            if stack2:
                total += stack2.pop()
            carry, digit = divmod(total, 10)
            new_node = ListNode(digit)
            new_node.next = head
            head = new_node
        return head
