# https://leetcode.com/problems/maximize-consecutive-elements-in-an-array-after-modification/

# Solution: Sort + DP — O(n log n) time, O(n) space
class Solution:
    def maxSelectedElements(self, nums: list[int]) -> int:
        nums.sort()
        dp: dict[int, int] = {}
        ans = 0
        for x in nums:
            dp[x + 1] = dp.get(x, 0) + 1
            dp[x] = dp.get(x - 1, 0) + 1
            ans = max(ans, dp[x + 1], dp[x])
        return ans
