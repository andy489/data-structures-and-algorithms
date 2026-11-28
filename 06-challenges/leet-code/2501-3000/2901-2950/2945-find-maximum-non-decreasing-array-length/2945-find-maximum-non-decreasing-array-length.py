# https://leetcode.com/problems/find-maximum-non-decreasing-array-length/

from collections import deque

class Solution:
    def findMaximumLength(self, nums: list[int]) -> int:
        n = len(nums)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + nums[i]

        dp = [0] * (n + 1)
        last = [0] * (n + 1)
        dq = deque([0])

        for i in range(1, n + 1):
            while len(dq) > 1 and last[dq[0]] > prefix[i] - prefix[dq[0]]:
                dq.popleft()
            j = dq[0]
            dp[i] = dp[j] + 1
            last[i] = prefix[i] - prefix[j]
            while dq and dp[i] >= dp[dq[-1]] and last[i] <= last[dq[-1]]:
                dq.pop()
            dq.append(i)

        return dp[n]
