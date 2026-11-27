# https://leetcode.com/problems/apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k/

class Solution:
    def minOperations(self, k: int) -> int:
        if k == 1: return 0
        import math
        ans = k - 1
        for i in range(k):
            val = i + 1
            j = max(0, math.ceil(math.log2(k / val))) if val < k else 0
            ans = min(ans, i + j)
        return ans
