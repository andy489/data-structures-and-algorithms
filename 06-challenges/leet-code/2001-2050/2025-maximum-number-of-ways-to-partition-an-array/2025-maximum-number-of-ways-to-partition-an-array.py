# https://leetcode.com/problems/maximum-number-of-ways-to-partition-an-array/

class Solution:
    def waysToPartition(self, nums: list[int], k: int) -> int:
        from collections import defaultdict
        n = len(nums)
        prefix = [0] * n
        prefix[0] = nums[0]
        for i in range(1, n):
            prefix[i] = prefix[i-1] + nums[i]
        total = prefix[-1]
        res = sum(1 for i in range(n-1) if 2 * prefix[i] == total)
        left, right = defaultdict(int), defaultdict(int)
        for i in range(1, n):
            right[prefix[i-1]] += 1
        for j in range(n):
            new_total = total - nums[j] + k
            if new_total % 2 == 0:
                half = new_total // 2
                diff = k - nums[j]
                cnt = left[half - diff] + right[half]
                res = max(res, cnt)
            right[prefix[j]] -= 1
            if j < n - 1:
                left[prefix[j]] += 1
        return res
