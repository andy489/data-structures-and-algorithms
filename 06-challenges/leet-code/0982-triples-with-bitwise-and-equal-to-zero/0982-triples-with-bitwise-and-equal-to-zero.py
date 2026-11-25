# https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/

class Solution:
    def countTriplets(self, nums: list[int]) -> int:
        pair_count = [0] * (1 << 16)
        for a in nums:
            for b in nums:
                pair_count[a & b] += 1
        ans = 0
        for c in nums:
            for v, cnt in enumerate(pair_count):
                if cnt and (v & c) == 0:
                    ans += cnt
        return ans
