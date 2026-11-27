# https://leetcode.com/problems/minimum-operations-to-make-array-parity-alternating/

from typing import List

class Solution:
    def minOperations(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # Count mismatches for 2 patterns
        # Pattern 0: even indices have even parity, odd indices have odd parity
        # Pattern 1: even indices have odd parity, odd indices have even parity
        mismatch = [0, 0]
        for i, v in enumerate(nums):
            parity = abs(v) % 2
            if parity != i % 2:
                mismatch[0] += 1
            if parity != (1 - i % 2):
                mismatch[1] += 1

        min_ops = min(mismatch)
        p = 0 if mismatch[0] <= mismatch[1] else 1

        # Compute range after adjustments
        vals = []
        for i, v in enumerate(nums):
            want = i % 2 if p == 0 else 1 - i % 2
            parity = abs(v) % 2
            if parity != want:
                # Include both v+1 and v-1 (both change parity)
                vals.extend([v + 1, v - 1])
            else:
                vals.append(v)

        return [min_ops, max(vals) - min(vals)]
