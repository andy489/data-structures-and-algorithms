# https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/

class Solution:
    def maximumLength(self, nums: list[int]) -> int:
        from collections import Counter
        import math
        freq = Counter(nums)
        ans = 1
        if 1 in freq:
            f = freq[1]
            ans = f if f % 2 == 1 else f - 1
        for x in freq:
            if x == 1: continue
            sq = int(math.isqrt(x))
            if sq * sq == x and freq.get(sq, 0) >= 2: continue
            length = 0
            cur = x
            while freq.get(cur, 0) >= 2:
                length += 2
                cur = cur * cur
            if freq.get(cur, 0) >= 1:
                length += 1
            ans = max(ans, length)
        return ans
