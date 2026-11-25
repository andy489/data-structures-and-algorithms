# https://leetcode.com/problems/number-of-squareful-arrays/

import math

class Solution:
    def numSquarefulPerms(self, nums: list[int]) -> int:
        nums.sort()
        n = len(nums)
        used = [False] * n
        self.ans = 0

        def is_square(x):
            s = int(math.isqrt(x))
            return s * s == x

        def backtrack(path):
            if len(path) == n:
                self.ans += 1
                return
            for i in range(n):
                if used[i]:
                    continue
                if i > 0 and nums[i] == nums[i-1] and not used[i-1]:
                    continue
                if path and not is_square(path[-1] + nums[i]):
                    continue
                used[i] = True
                path.append(nums[i])
                backtrack(path)
                path.pop()
                used[i] = False

        backtrack([])
        return self.ans
