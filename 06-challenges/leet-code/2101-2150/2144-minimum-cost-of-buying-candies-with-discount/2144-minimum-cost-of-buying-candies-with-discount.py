# https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/
class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        cost.sort(reverse=True)
        return sum(c for i, c in enumerate(cost) if (i + 1) % 3 != 0)
