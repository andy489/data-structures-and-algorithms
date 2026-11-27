# https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
class Solution:
    def earliestFullBloom(self, plantTime: list, growTime: list) -> int:
        seeds = sorted(zip(plantTime, growTime), key=lambda x: -x[1])
        current_day = 0
        max_bloom = 0
        for p, g in seeds:
            current_day += p
            max_bloom = max(max_bloom, current_day + g)
        return max_bloom
