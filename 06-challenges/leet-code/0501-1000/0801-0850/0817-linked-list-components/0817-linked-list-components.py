# https://leetcode.com/problems/linked-list-components/

class Solution:
    def numComponents(self, head, nums: list[int]) -> int:
        s = set(nums)
        count = 0
        in_component = False
        cur = head
        while cur:
            if cur.val in s:
                if not in_component:
                    count += 1
                    in_component = True
            else:
                in_component = False
            cur = cur.next
        return count
