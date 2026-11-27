# https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/

class Solution:
    def getMaxLen(self, nums: list[int]) -> int:
        result = 0
        start = 0
        first_neg = -1
        neg_count = 0
        for i, x in enumerate(nums):
            if x == 0:
                start = i + 1
                first_neg = -1
                neg_count = 0
            else:
                if x < 0:
                    neg_count += 1
                    if first_neg == -1:
                        first_neg = i
                if neg_count % 2 == 0:
                    result = max(result, i - start + 1)
                else:
                    result = max(result, i - first_neg)
        return result
