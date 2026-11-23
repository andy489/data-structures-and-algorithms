# https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

class Solution:
    def numberOfArithmeticSlices(self, nums: list[int]) -> int:
        from collections import defaultdict
        n = len(nums)
        dp = [defaultdict(int) for _ in range(n)]
        answer = 0
        for i in range(1, n):
            for j in range(i):
                diff = nums[i] - nums[j]
                count_at_j = dp[j][diff]
                answer += count_at_j
                dp[i][diff] += count_at_j + 1
        return answer
