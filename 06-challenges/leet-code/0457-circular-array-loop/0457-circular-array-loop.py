# https://leetcode.com/problems/circular-array-loop/

from typing import List

class Solution:
    def circularArrayLoop(self, nums: List[int]) -> bool:
        n = len(nums)

        def nxt(i: int) -> int:
            return (i + nums[i]) % n

        for i in range(n):
            if nums[i] == 0:
                continue
            slow, fast = i, nxt(i)
            while nums[slow] * nums[fast] > 0 and nums[slow] * nums[nxt(fast)] > 0:
                if slow == fast:
                    if slow == nxt(slow):
                        break
                    return True
                slow = nxt(slow)
                fast = nxt(nxt(fast))
            # mark path as visited
            j = i
            while nums[j] * nums[nxt(j)] > 0:
                tmp = nxt(j)
                nums[j] = 0
                j = tmp
        return False
