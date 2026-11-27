# https://leetcode.com/problems/constrained-subsequence-sum/

class Solution:
    def constrainedSubsetSum(self, nums: list[int], k: int) -> int:
        from collections import deque
        n = len(nums)
        dp = [0] * n
        dq = deque()
        ans = float('-inf')
        for i in range(n):
            dp[i] = nums[i] + (max(0, dp[dq[0]]) if dq else 0)
            ans = max(ans, dp[i])
            while dq and dp[dq[-1]] <= dp[i]:
                dq.pop()
            dq.append(i)
            if i - dq[0] >= k:
                dq.popleft()
        return ans
