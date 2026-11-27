# https://leetcode.com/problems/minimum-positive-sum-subarray/

# Solution: Prefix Sum + Brute Force — O(n * (r - l + 1)) time, O(n) space
class Solution:
    def minimumSumSubarray(self, nums: list[int], l: int, r: int) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
        ans = float('inf')
        for k in range(l, r + 1):
            for i in range(n - k + 1):
                s = pre[i + k] - pre[i]
                if s > 0:
                    ans = min(ans, s)
        return ans if ans != float('inf') else -1
