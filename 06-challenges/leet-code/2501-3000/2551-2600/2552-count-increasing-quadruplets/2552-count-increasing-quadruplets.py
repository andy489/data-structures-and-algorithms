# https://leetcode.com/problems/count-increasing-quadruplets/

# Solution: O(n²) DP — count valid (i,k,j) triples then find l positions
class Solution:
    def countQuadruplets(self, nums: list[int]) -> int:
        n = len(nums)
        ans = 0
        # dp[j] = number of valid (i, k) pairs with i < k < j and nums[i] < nums[k] < nums[j]
        dp = [0] * n
        for k in range(n):
            cnt_less = sum(1 for i in range(k) if nums[i] < nums[k])
            for j in range(k + 1, n):
                if nums[j] > nums[k]:
                    ans += dp[j]
            for j in range(k + 1, n):
                if nums[j] > nums[k]:
                    dp[j] += cnt_less
        return ans
