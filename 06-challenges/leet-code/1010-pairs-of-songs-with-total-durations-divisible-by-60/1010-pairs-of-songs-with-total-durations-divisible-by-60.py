# https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

class Solution:
    def numPairsDivisibleBy60(self, time: list[int]) -> int:
        count = [0] * 60
        ans = 0
        for t in time:
            r = t % 60
            ans += count[(60 - r) % 60]
            count[r] += 1
        return ans
