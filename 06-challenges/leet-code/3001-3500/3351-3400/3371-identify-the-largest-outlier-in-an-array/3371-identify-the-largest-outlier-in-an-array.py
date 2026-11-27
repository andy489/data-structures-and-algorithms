# https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

class Solution:
    def getLargestOutlier(self, nums: list[int]) -> int:
        from collections import Counter
        total = sum(nums)
        freq = Counter(nums)
        ans = float('-inf')
        for x in nums:
            remainder = total - x
            if remainder % 2 != 0:
                continue
            need = remainder // 2
            freq[x] -= 1
            if freq.get(need, 0) > 0:
                ans = max(ans, x)
            freq[x] += 1
        return ans
