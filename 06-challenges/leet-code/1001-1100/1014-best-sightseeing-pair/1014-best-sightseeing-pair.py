# https://leetcode.com/problems/best-sightseeing-pair/

class Solution:
    def maxScoreSightseeingPair(self, values: list[int]) -> int:
        max_i = values[0]
        ans = 0
        for j in range(1, len(values)):
            ans = max(ans, max_i + values[j] - j)
            max_i = max(max_i, values[j] + j)
        return ans
