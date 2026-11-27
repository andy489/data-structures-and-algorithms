# https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

class Solution:
    def numSubseq(self, nums: list[int], target: int) -> int:
        MOD = 10**9 + 7
        nums.sort()
        n = len(nums)
        pw = [1] * n
        for i in range(1, n):
            pw[i] = pw[i-1] * 2 % MOD
        l, r = 0, n - 1
        ans = 0
        while l <= r:
            if nums[l] + nums[r] <= target:
                ans = (ans + pw[r-l]) % MOD
                l += 1
            else:
                r -= 1
        return ans
