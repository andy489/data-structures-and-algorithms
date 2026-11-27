# https://leetcode.com/problems/put-marbles-in-bags/

# Solution: Sort Adjacent Pair Sums — O(n log n) time, O(n) space
class Solution:
    def putMarbles(self, weights: list[int], k: int) -> int:
        pair_sums = sorted(weights[i] + weights[i + 1] for i in range(len(weights) - 1))
        return sum(pair_sums[-(k - 1):]) - sum(pair_sums[:k - 1])
