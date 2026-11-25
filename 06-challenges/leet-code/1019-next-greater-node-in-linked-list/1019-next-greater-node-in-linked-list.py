# https://leetcode.com/problems/next-greater-node-in-linked-list/

class Solution:
    def nextLargerNodes(self, head: 'ListNode') -> list[int]:
        vals = []
        cur = head
        while cur:
            vals.append(cur.val)
            cur = cur.next
        ans = [0] * len(vals)
        stack = []
        for i, v in enumerate(vals):
            while stack and vals[stack[-1]] < v:
                ans[stack.pop()] = v
            stack.append(i)
        return ans
