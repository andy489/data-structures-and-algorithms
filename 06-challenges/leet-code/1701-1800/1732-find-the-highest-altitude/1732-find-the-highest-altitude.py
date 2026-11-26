# https://leetcode.com/problems/find-the-highest-altitude/

class Solution:
    def largestAltitude(self, gain: list[int]) -> int:
        altitude = max_alt = 0
        for g in gain:
            altitude += g
            max_alt = max(max_alt, altitude)
        return max_alt
