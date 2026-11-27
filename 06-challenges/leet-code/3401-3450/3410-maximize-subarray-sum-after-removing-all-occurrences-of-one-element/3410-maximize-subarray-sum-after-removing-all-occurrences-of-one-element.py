# https://leetcode.com/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/
class Solution:
    def maximumSumSubarray(self, nums: list[int]) -> int:
        def kadane(skip):
            cur = 0
            best = float('-inf')
            has_element = False
            for v in nums:
                if v == skip:
                    continue
                has_element = True
                cur += v
                if cur > best:
                    best = cur
                if cur < 0:
                    cur = 0
            return best if has_element else float('-inf')

        ans = kadane(None)  # no removal
        negatives = set(x for x in nums if x < 0)
        for x in negatives:
            ans = max(ans, kadane(x))
        return ans
