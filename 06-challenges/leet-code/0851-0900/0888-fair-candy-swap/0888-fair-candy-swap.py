# https://leetcode.com/problems/fair-candy-swap/

class Solution:
    def fairCandySwap(self, aliceSizes: list[int], bobSizes: list[int]) -> list[int]:
        delta = (sum(bobSizes) - sum(aliceSizes)) // 2
        bob_set = set(bobSizes)
        for a in aliceSizes:
            if a + delta in bob_set:
                return [a, a + delta]
